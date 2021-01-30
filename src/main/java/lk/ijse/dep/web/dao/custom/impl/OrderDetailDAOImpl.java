package lk.ijse.dep.web.dao.custom.impl;

import lk.ijse.dep.web.dao.CrudDaoImpl;
import lk.ijse.dep.web.dao.CrudUtil;
import lk.ijse.dep.web.dao.custom.OrderDetailDAO;
import lk.ijse.dep.web.entity.OrderDetail;
import lk.ijse.dep.web.entity.OrderDetailPK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-14
 **/
public class OrderDetailDAOImpl extends CrudDaoImpl<OrderDetail,OrderDetailPK> implements OrderDetailDAO {
}
