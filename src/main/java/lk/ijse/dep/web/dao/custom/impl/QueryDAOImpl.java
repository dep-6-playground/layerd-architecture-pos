package lk.ijse.dep.web.dao.custom.impl;

import lk.ijse.dep.web.dao.custom.QueryDAO;
import lk.ijse.dep.web.entity.CustomEntity;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
public class QueryDAOImpl implements QueryDAO {
    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) throws Exception {
        this.entityManager = entityManager;
    }


    @Override
    public List<CustomEntity> getOrderInfo(String customerId) throws Exception {
      /*  ResultSet rst = CrudUtil.execute(connection, "SELECT c.id AS customer_id, c.name AS customer_name, o.id AS order_id, o.date AS order_date,\n" +
                "       SUM(od.qty * od.unit_price) as order_detail\n" +
                "FROM customer c\n" +
                "INNER JOIN `order` o on c.id = o.customer_id\n" +
                "INNER JOIN order_detail od on o.id = od.order_id\n" +
                "WHERE c.id=? GROUP BY o.id;", customerId);
        List<CustomEntity> orders = new ArrayList<>();
        while (rst.next()){
            orders.add(new CustomEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDate(4),
                    rst.getBigDecimal(5)));
        }*/
        return null;
    }
}
