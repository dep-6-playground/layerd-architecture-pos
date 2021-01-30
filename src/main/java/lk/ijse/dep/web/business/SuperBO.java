package lk.ijse.dep.web.business;

import javax.persistence.EntityManager;
import java.sql.Connection;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-18
 **/
public interface SuperBO {

    public void setEntityManager(EntityManager entityManager) throws Exception;
}
