package lk.ijse.dep.web.dao;



import lk.ijse.dep.web.entity.Order;

import java.sql.Connection;
import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
public interface OrderDAO {

    public void setConnection(Connection connection) throws Exception;

    public boolean saveOrder(Order order) throws Exception;

    public boolean updateOrder(Order order) throws Exception;

    public boolean deleteOrder(String id) throws Exception;

    public List<Order> getAllOrders() throws Exception;

    public Order getOrder(String id) throws Exception;
}
