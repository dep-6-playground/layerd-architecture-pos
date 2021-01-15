package lk.ijse.dep.web.dao;

import lk.ijse.dep.web.entity.Order;
import lk.ijse.dep.web.entity.OrderDetail;
import lk.ijse.dep.web.entity.OrderDetailPK;

import java.sql.Connection;
import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
public interface OrderDetailDAO {

    public void setConnection(Connection connection) throws Exception;

    public boolean saveOrderDetail(OrderDetail orderDetail) throws Exception;

    public boolean updateOrderDetail(OrderDetail orderDetail) throws Exception;

    public boolean deleteOrderDetail(OrderDetailPK pk) throws Exception;

    public List<OrderDetail> getAllOrderDetails() throws Exception;

    public OrderDetail getOrderDetail(OrderDetailPK pk) throws Exception;
}
