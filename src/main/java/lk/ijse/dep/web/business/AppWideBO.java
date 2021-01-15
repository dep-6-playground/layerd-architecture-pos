package lk.ijse.dep.web.business;

import lk.ijse.dep.web.dao.DAOTypes;
import lk.ijse.dep.web.dao.DaoFactory;
import lk.ijse.dep.web.dao.custom.CustomerDAO;
import lk.ijse.dep.web.dao.custom.ItemDAO;
import lk.ijse.dep.web.dao.custom.OrderDAO;
import lk.ijse.dep.web.dao.custom.OrderDetailDAO;
import lk.ijse.dep.web.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.dep.web.dao.custom.impl.ItemDAOImpl;
import lk.ijse.dep.web.dao.custom.impl.OrderDAOImpl;
import lk.ijse.dep.web.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.dep.web.dto.CustomerDTO;
import lk.ijse.dep.web.dto.ItemDTO;
import lk.ijse.dep.web.dto.OrderDTO;
import lk.ijse.dep.web.entity.Customer;

import java.sql.Connection;
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
        this.customerDAO = DaoFactory.getInstance().<CustomerDAO>getDAO(DAOTypes.CUSTOMER);
        this.itemDAO = DaoFactory.getInstance().getDAO(DAOTypes.ITEM);
        this.orderDAO = DaoFactory.getInstance().getDAO(DAOTypes.ORDER);
        this.orderDetailDAO = DaoFactory.getInstance().getDAO(DAOTypes.ORDER_DETAIL);

        this.customerDAO.setConnection(connection);
        this.itemDAO.setConnection(connection);
        this.orderDAO.setConnection(connection);
        this.orderDetailDAO.setConnection(connection);
    }

    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        Customer c = new Customer(dto.getId(),dto.getName(),dto.getAddress());
        return customerDAO.save(c);
    }

    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        Customer c = new Customer(dto.getId(),dto.getName(), dto.getAddress());
        return customerDAO.update(c);
    }

    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerDAO.getAll().stream()
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
