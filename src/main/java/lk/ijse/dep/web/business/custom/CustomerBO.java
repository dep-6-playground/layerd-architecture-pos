package lk.ijse.dep.web.business.custom;

import lk.ijse.dep.web.business.SuperBO;
import lk.ijse.dep.web.dto.CustomerDTO;

import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-18
 **/
public interface CustomerBO extends SuperBO {

    void saveCustomer(CustomerDTO dto) throws Exception;
    void updateCustomer(CustomerDTO dto) throws Exception;
    void deleteCustomer(String id) throws Exception;

    List<CustomerDTO> findAllCustomers() throws Exception;
}
