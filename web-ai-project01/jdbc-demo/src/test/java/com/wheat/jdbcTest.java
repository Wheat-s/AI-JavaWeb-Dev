package com.wheat;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcTest {
    /**
     * JDBC入门程序
     */
    @Test
    public void testUpdate() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String user = "root";
        String password = "12341234";
        Connection connection = DriverManager.getConnection(url, user, password);
        
        // 3.获取sql语句执行对象
        Statement statement = connection.createStatement();

        // 4.执行sql语句
        int i = statement.executeUpdate("update user set age = 25 where id = 1");
        System.out.println("SQL执行完毕影响到记录数为:" + i);
        
        // 5.释放资源
        statement.close();
        connection.close();
    }
}
