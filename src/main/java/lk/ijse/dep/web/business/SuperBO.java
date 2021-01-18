package lk.ijse.dep.web.business;

import java.sql.Connection;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-18
 **/
public interface SuperBO {

    public void setConnection(Connection connection) throws Exception;
}
