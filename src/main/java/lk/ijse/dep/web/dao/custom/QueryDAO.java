package lk.ijse.dep.web.dao.custom;

import lk.ijse.dep.web.dao.SuperDAO;
import lk.ijse.dep.web.entity.CustomEntity;

import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
public interface QueryDAO extends SuperDAO {

    List<CustomEntity> getOrderInfo(String customerId) throws Exception;
}
