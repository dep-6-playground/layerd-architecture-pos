package lk.ijse.dep.web.util;

import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Properties;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-30
 **/
public class JPAUtil {


    private static EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        org.slf4j.Logger logger = LoggerFactory.getLogger(JPAUtil.class);
        Properties prop = new Properties();
        try {
            prop.load(JPAUtil.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            logger.error("Failed to load the connection settings", e);
            e.printStackTrace();
        }
        return Persistence.createEntityManagerFactory("dep-6", prop);
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
