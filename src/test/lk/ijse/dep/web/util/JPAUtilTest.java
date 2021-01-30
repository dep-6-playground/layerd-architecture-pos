package lk.ijse.dep.web.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-30
 **/
public class JPAUtilTest {

    @Test
    public void getEntityManagerFactory() {
        assertNotNull(JPAUtil.getEntityManagerFactory());
    }
}
