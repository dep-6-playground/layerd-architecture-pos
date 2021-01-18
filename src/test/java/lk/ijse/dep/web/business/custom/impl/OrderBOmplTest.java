package lk.ijse.dep.web.business.custom.impl;

import lk.ijse.dep.web.ConnectionPool;
import lk.ijse.dep.web.business.BOFactory;
import lk.ijse.dep.web.business.BOTypes;
import lk.ijse.dep.web.business.custom.CustomerBO;
import lk.ijse.dep.web.business.custom.ItemBO;
import lk.ijse.dep.web.business.custom.OrderBO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-18
 **/
public class OrderBOmplTest {
    private static BasicDataSource pool;
    private Connection connection;
    private OrderBO customerBO;
    private ItemBO itemBO;


    @BeforeClass
    public static void executeClassBefore(){
        pool = ConnectionPool.getInstance().getPool();
    }

    @AfterClass
    public static void executeClassAfter(){
        try {
            pool.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Before
    public void prepareBeforeTest() throws Exception {
        connection = pool.getConnection();
        connection.setAutoCommit(false);
        customerBO = BOFactory.getInstance().getBO(BOTypes.CUSTOMER);
        customerBO.setConnection(connection);
    }

    @After
    public void finalizeAfterTest() throws SQLException {
        connection.rollback();
        connection.setAutoCommit(true);
        connection.close();
    }

    @Test
    public void placeOrder() {
    }

    private int getQty(String itemCode) throws Exception{
        return itemBO.findAllItems().stream().filter(dto -> dto.getCode().equals(itemCode)).findFirst().get().getQtyOnHand();
    }
}
