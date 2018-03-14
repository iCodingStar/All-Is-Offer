package cn.codingstar.offer.database;

import cn.codingstar.offer.database.pool.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: App.java
 * @time: 18-3-14 下午7:39
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class App {

    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = connection.createStatement();
        boolean result = statement.execute("SHOW DATABASES");
    }
}
