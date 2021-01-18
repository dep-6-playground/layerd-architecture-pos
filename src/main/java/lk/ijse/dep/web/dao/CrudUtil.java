package lk.ijse.dep.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
public class CrudUtil {
    public static <T> T execute(Connection connection, String sql, Object... params) throws Exception{
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i+1,params[i]);
        }
        if (sql.trim().matches("(?!)(SELECT).+")){
            return (T) pstm.executeQuery();
        }else{
            return (T) (Boolean) (pstm.executeUpdate()>0);
        }
    }
}

