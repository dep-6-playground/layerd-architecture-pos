package lk.ijse.dep.web.business.custom;

import lk.ijse.dep.web.business.SuperBO;
import lk.ijse.dep.web.dto.CustomerDTO;
import lk.ijse.dep.web.dto.ItemDTO;

import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-18
 **/
public interface ItemBO extends SuperBO {

    void saveItem(ItemDTO dto) throws Exception;
    void updateItem(ItemDTO dto) throws Exception;
    void deleteItem(String code) throws Exception;

    List<ItemDTO> findAllItems() throws Exception;
}
