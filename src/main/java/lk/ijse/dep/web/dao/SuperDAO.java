package lk.ijse.dep.web.dao;

import lk.ijse.dep.web.entity.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
public interface SuperDAO{
    public void setConnection(Connection connection) throws Exception;

}
