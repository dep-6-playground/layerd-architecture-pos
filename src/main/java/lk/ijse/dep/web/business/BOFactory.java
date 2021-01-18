package lk.ijse.dep.web.business;

import lk.ijse.dep.web.business.custom.impl.CustomerBOImpl;
import lk.ijse.dep.web.business.custom.impl.ItemBOImpl;
import lk.ijse.dep.web.business.custom.impl.OrderBOmpl;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-18
 **/
public class BOFactory {

    private static BOFactory boFactory;

    public BOFactory() {
    }

    public static BOFactory getInstance(){
        return (boFactory == null)?(boFactory = new BOFactory()): boFactory;
    }

    public <T extends SuperBO> T getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case ITEM:
                return (T) new ItemBOImpl();
            case ORDER:
                return (T) new OrderBOmpl();
            default:
                return null;
        }
    }
}
