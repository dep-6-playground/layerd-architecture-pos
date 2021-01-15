package lk.ijse.dep.web.dao.custom.impl;


import lk.ijse.dep.web.dao.custom.OrderDAO;
import lk.ijse.dep.web.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-14
 **/
public class OrderDAOImpl implements OrderDAO {
    private Connection connection;

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }

    @Override
    public boolean save(Order order) throws Exception {
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO `order` VALUES (?,?,?)");
        pstm.setString(1, order.getId());
        pstm.setDate(2, order.getDate());
        pstm.setString(3, order.getCustomerId());
        return (pstm.executeUpdate() > 0) ;
    }

    @Override
    public boolean update(Order order) throws Exception {
        PreparedStatement pst = connection.prepareStatement("UPDATE `order` SET date=?,customer_id=? WHERE id=?");
        pst.setDate(1, order.getDate());
        pst.setString(2, order.getCustomerId());
        pst.setString(3, order.getId());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM `order` WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeUpdate() > 0;
    }

    @Override
    public List<Order> getAll() throws Exception {
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM `order`");
        List<Order> orders = new ArrayList<>();
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            orders.add(
                    new Order(
                            rst.getString("id"),
                            rst.getDate("date"),
                            rst.getString("customer_id")));
        }
        return orders;
    }

    @Override
    public Order get(String id) throws Exception {
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM `order` WHERE id=?");
        pstm.setString(1, id);
        ResultSet rst = pstm.executeQuery();

        if (rst.next()) {
            return new Order(
                    rst.getString("id"), rst.getDate("date"),rst.getString("customer_id"));
        } else {
            return null;
        }
    }


}
