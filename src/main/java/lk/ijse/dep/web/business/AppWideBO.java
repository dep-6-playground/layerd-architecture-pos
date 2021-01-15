package lk.ijse.dep.web.business;

import lk.ijse.dep.web.dao.CustomerDAO;
import lk.ijse.dep.web.dao.ItemDAO;
import lk.ijse.dep.web.dao.OrderDAO;
import lk.ijse.dep.web.dao.OrderDetailDAO;
import lk.ijse.dep.web.dao.impl.CustomerDAOImpl;
import lk.ijse.dep.web.dao.impl.ItemDAOImpl;
import lk.ijse.dep.web.dao.impl.OrderDAOImpl;
import lk.ijse.dep.web.dao.impl.OrderDetailDAOImpl;
import lk.ijse.dep.web.dto.CustomerDTO;
import lk.ijse.dep.web.dto.ItemDTO;
import lk.ijse.dep.web.dto.OrderDTO;
import lk.ijse.dep.web.entity.Customer;
import lk.ijse.dep.web.entity.Item;
import lk.ijse.dep.web.entity.Order;
import lk.ijse.dep.web.entity.OrderDetail;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-14
 **/
public class AppWideBO {

    private CustomerDAO customerDAO;
    private ItemDAO itemDAO;
    private OrderDAO orderDAO;
    private OrderDetailDAO orderDetailDAO;

    public AppWideBO(Connection connection) throws Exception {
        this.customerDAO = new CustomerDAOImpl();
        this.itemDAO = new ItemDAOImpl();
        this.orderDAO = new OrderDAOImpl();
        this.orderDetailDAO = new OrderDetailDAOImpl();

        this.customerDAO.setConnection(connection);
        this.itemDAO.setConnection(connection);
        this.orderDAO.setConnection(connection);
        this.orderDetailDAO.setConnection(connection);
    }

    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        Customer c = new Customer(dto.getId(),dto.getName(),dto.getAddress());
        return customerDAO.saveCustomer(c);
    }

    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        Customer c = new Customer(dto.getId(),dto.getName(), dto.getAddress());
        return customerDAO.updateCustomer(c);
    }

    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.deleteCustomer(id);
    }

    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerDAO.getAllCustomers().stream()
                .map(c->new CustomerDTO(c.getId(),c.getName(),c.getAddress())).collect(Collectors.toList());
    }

    //--------------------------------------
    public boolean saveItem(ItemDTO dto) throws Exception {
        return true;
    }

    public boolean updateItem(ItemDTO dto) throws Exception {
        return true;
    }

    public boolean deleteItem(String code) throws Exception {
        return true;
    }

    public List<ItemDTO> getAllItems() throws Exception {
        return null;
    }

    //----------------------------------------

    public boolean saveOrder(OrderDTO dto) throws Exception {
        return true;
    }

}
