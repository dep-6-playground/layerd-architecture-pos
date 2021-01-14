package lk.ijse.dep.web.business;

import lk.ijse.dep.web.dao.DataAccess;
import lk.ijse.dep.web.dto.CustomerDTO;
import lk.ijse.dep.web.entity.Customer;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-14
 **/
public class AppWideBO {

    private DataAccess dataAccess;

    public AppWideBO(Connection connection) {
        this.dataAccess = new DataAccess(connection);
    }

    public boolean saveCustomer(CustomerDTO dto) throws Exception{
        Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress());
        return dataAccess.saveCustomer(customer);
    }
    public boolean updateCustomer(CustomerDTO dto) throws Exception{
        Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress());
        return dataAccess.updateCustomer(customer);
    }
    public boolean deleteCustomer(String id) throws Exception{
        return dataAccess.deleteCustomer(id);
    }
    public List<CustomerDTO> getAllCustomers() throws Exception{
       return dataAccess.getAllCustomers().stream().map(c -> new CustomerDTO(c.getId(),c.getName(),c.getAddress())).collect(Collectors.toList());
    }
}
