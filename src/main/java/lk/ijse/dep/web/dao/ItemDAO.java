package lk.ijse.dep.web.dao;


import lk.ijse.dep.web.entity.Item;

import java.sql.Connection;
import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
public interface ItemDAO {

    public void setConnection(Connection connection) throws Exception;

    public boolean saveItem(Item item) throws Exception;

    public boolean updateItem(Item item) throws Exception;

    public boolean deleteItem(String code) throws Exception;

    public List<Item> getAllItems() throws Exception;

    public Item getItem(String code) throws Exception;
}
