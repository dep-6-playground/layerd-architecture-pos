package lk.ijse.dep.web.business.custom.impl;

import lk.ijse.dep.web.business.custom.CustomerBO;
import lk.ijse.dep.web.dao.DAOTypes;
import lk.ijse.dep.web.dao.DaoFactory;
import lk.ijse.dep.web.dao.custom.CustomerDAO;
import lk.ijse.dep.web.dto.CustomerDTO;
import lk.ijse.dep.web.entity.Customer;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-18
 **/
public class CustomerBOImpl implements CustomerBO {

    //Dependency
    private CustomerDAO customerDAO;
    private Connection connection;

    public CustomerBOImpl() {
        customerDAO = DaoFactory.getInstance().getDAO(DAOTypes.CUSTOMER);
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
        customerDAO.setConnection(connection);

    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.update(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public List<CustomerDTO> findAllCustomers() throws Exception {
        return customerDAO.getAll().stream().map(
                c->new CustomerDTO(c.getId(),c.getName(),c.getAddress())).collect(Collectors.toList());
    }


}
