package lk.ijse.dep.web.dao.custom;

import lk.ijse.dep.web.dao.CrudDao;
import lk.ijse.dep.web.dao.SuperDAO;
import lk.ijse.dep.web.entity.Order;
import lk.ijse.dep.web.entity.OrderDetail;
import lk.ijse.dep.web.entity.OrderDetailPK;

import java.sql.Connection;
import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
public interface OrderDetailDAO extends CrudDao<OrderDetail,OrderDetailPK> {

}
