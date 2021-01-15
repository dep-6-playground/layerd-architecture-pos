package lk.ijse.dep.web.dao;

import lk.ijse.dep.web.entity.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
public interface CustomerDAO {

    public void setConnection(Connection connection) throws Exception;

    public boolean saveCustomer(Customer customer) throws Exception;

    public boolean updateCustomer(Customer customer) throws Exception;

    public boolean deleteCustomer(String id) throws Exception;

    public List<Customer> getAllCustomers() throws Exception;

    public Customer getCustomer(String id) throws Exception;
}
