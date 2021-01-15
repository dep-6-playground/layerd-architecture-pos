package lk.ijse.dep.web.dao;

import lk.ijse.dep.web.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.dep.web.dao.custom.impl.ItemDAOImpl;
import lk.ijse.dep.web.dao.custom.impl.OrderDAOImpl;
import lk.ijse.dep.web.dao.custom.impl.OrderDetailDAOImpl;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return (daoFactory == null)? (daoFactory = new DaoFactory()) : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case ITEM:
                return (T) new ItemDAOImpl();
            case ORDER:
                return (T) new OrderDAOImpl();
            case ORDER_DETAIL:
                return (T) new OrderDetailDAOImpl();
            default:
                return null;
        }
    }
}
