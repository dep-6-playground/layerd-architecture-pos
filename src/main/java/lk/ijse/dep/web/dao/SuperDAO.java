package lk.ijse.dep.web.dao;

import lk.ijse.dep.web.entity.Customer;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
public interface SuperDAO{

    default void setEntityManager(EntityManager entityManager) throws Exception{};

}

