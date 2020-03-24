package org.teahel.uitls;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author L.T.J
 * @Date 2020/3/23 10:53
 * @Version 1.0
 */
public class JDBCUtils {

    // 获得c3p0连接池对象
    private static ComboPooledDataSource ds = new ComboPooledDataSource();

    /**
     * 获得数据库连接对象
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 获得c3p0连接池对象
     * @return
     */
    public static DataSource getDataSource() {
        return ds;
    }
}