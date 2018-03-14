package cn.codingstar.offer.database.pool;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: JdbcUtil.java
 * @time: 18-3-14 下午7:39
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class JdbcUtil {

    private static JdbcPool pool = new JdbcPool();

    /**
     * 获取数据库连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    /**
     * @param conn
     * @param statement
     * @param resultSet
     */
    public static void release(Connection conn, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                // 关闭存储查询结果的ResultSet对象
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                // 关闭负责执行sqldeStatement对象
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                // 关闭Connection数据库连接对象
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
