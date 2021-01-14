package lk.ijse.dep.web.api;

import lk.ijse.dep.web.dto.CustomerDTO;
import lk.ijse.dep.web.dto.OrderDTO;
import lk.ijse.dep.web.dto.OrderDetailDTO;
import lk.ijse.dep.web.exception.HttpResponseException;
import lk.ijse.dep.web.exception.ResponseExceptionUtil;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/api/v1/orders")
public class OrderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            super.service(req, resp);
        }catch (Throwable t){
            ResponseExceptionUtil.handle(t,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        final BasicDataSource cp = (BasicDataSource) getServletContext().getAttribute("cp");

        try (Connection connection = cp.getConnection()) {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM customer");
            List<CustomerDTO> customers = new ArrayList<>();

            while (rst.next()) {
                customers.add(new CustomerDTO(rst.getString("id"),
                        rst.getString("name"),
                        rst.getString("address")));
            }

            resp.setContentType("application/json");
            resp.getWriter().println(jsonb.toJson(customers));

        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Jsonb jsonb = JsonbBuilder.create();
        final BasicDataSource cp = (BasicDataSource) getServletContext().getAttribute("cp");

        try (Connection connection = cp.getConnection()) {
            OrderDTO dto = jsonb.fromJson(req.getReader(), OrderDTO.class);

            if (dto.getOrderId() == null || dto.getOrderId().trim().isEmpty() || dto.getOrderDate() == null || dto.getOrderDetails().isEmpty()) {
                throw new HttpResponseException(400, "Invalid order details" , null);
            }

            try {

                /* Let's start transactions */
                connection.setAutoCommit(false);

                PreparedStatement pstm = connection.prepareStatement("INSERT INTO `order` VALUES (?,?,?)");
                pstm.setString(1, dto.getOrderId());
                pstm.setDate(2, Date.valueOf(dto.getOrderDate()));
                pstm.setString(3, dto.getCustomerId());

                if (pstm.executeUpdate() > 0) {

                    pstm = connection.prepareStatement("INSERT INTO order_detail VALUE (?,?,?,?)");
                    PreparedStatement pstm2 = connection.prepareStatement("UPDATE item SET qty_on_hand = qty_on_hand - ? WHERE code=?");
                    for (OrderDetailDTO detail : dto.getOrderDetails()) {
                        pstm.setString(1, dto.getOrderId());
                        pstm.setString(2, detail.getItemCode());
                        pstm.setInt(3, detail.getQty());
                        pstm.setBigDecimal(4, detail.getUnitPrice());

                        pstm2.setInt(1,detail.getQty());
                        pstm2.setString(2,detail.getItemCode());

                        if (pstm.executeUpdate() == 0 || pstm2.executeUpdate() == 0){
                            throw new HttpResponseException(500, "Failed to save the order, transaction failed during order details processing", null);
                        }
                    }

                    connection.commit();
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                } else {
                    throw new HttpResponseException(500, "Failed to save the order, transaction failed", null);
                }

            }catch (Throwable t){
                /* In case something happens unexpectedly */
                connection.rollback();
                throw t;
            }
        }catch (SQLIntegrityConstraintViolationException exp){
            throw new HttpResponseException(400, "Duplicate entry", exp);
        } catch (JsonbException exp) {
            exp.printStackTrace();
            throw new HttpResponseException(400, "Failed to read the JSON", exp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
