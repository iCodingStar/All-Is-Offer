package cn.codingstar.offer.database.pool;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: JdbcPool.java
 * @time: 18-3-14 下午7:40
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: http://blog.csdn.net/kingcat666/article/details/77678990
 * @desc: Java数据库连接池实现
 */
public class JdbcPool implements DataSource {

    /**
     * Vector是线程安全的数组
     */
    private static Vector<Connection> connections = new Vector<>();

    static {
        // 在静态代码块中加载db.properties
        InputStream in = new JdbcPool().getClass().getClassLoader().getResourceAsStream("config/db.properties");

        Properties props = new Properties();

        try {
            // 加载配置文件流
            props.load(in);
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            // 数据库连接池初始化连接数大小
            int jdbcPoolInitSize = Integer.valueOf(props.getProperty("jdbcPoolInitSize"));

            // 加载数据库驱动
            Class.forName(driver);

            // 预先创建一定数量的数据库连接放在池中
            for (int i = 0; i < jdbcPoolInitSize; i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                System.out.println("获取到了连接： " + connection);
                connections.addElement(connection);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        // 如果数据库连接池中的对象的个数大于0
        if (connections.size() > 0) {
            // 从连接池中获取一个连接
            final Connection connection = connections.firstElement();
            // 删除取用的连接
            connections.remove(connection);


            return (Connection) Proxy.newProxyInstance(JdbcPool.class.getClassLoader(), connection.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (!method.getName().equals("close")) {
                        return method.invoke(connection, args);
                    } else {
                        // 如果调用的是Connection的close方法，把Connection还给数据库连接池
                        connections.add(connection);
                        System.out.println(connection + "已经还给数据库连接池啦！");
                        System.out.println("当前数据库连接池大小为：" + connections.size());
                    }
                    return null;
                }
            });
        } else {
            throw new RuntimeException("数据库繁忙...");
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
