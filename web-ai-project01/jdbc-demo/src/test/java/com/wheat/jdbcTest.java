package com.wheat;

import com.wheat.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testSelect() {
        String url = "jdbc:mysql://localhost:3306/web01"; // 替换为你的数据库地址
        String username = "root"; // 替换为你的数据库用户名
        String password = "12341234"; // 替换为你的数据库密码


        // SQL 查询语句 
        String sql = "SELECT id, username, password, name, age FROM user WHERE username = ? AND password = ?";
        // 创建一个 ArrayList 用于存储查询结果
        List<User> userList = new ArrayList<>();

        try (
                // 创建数据库连接
                Connection conn = DriverManager.getConnection(url, username, password);
                //  创建 PreparedStatement 对象 
                //  PreparedStatement是一个用于执行 SQL 语句的接口，
                //  它提供了执行 SQL 查询和操作数据库等功能。
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            // 设置查询参数
            pstmt.setString(1, "daqiao");
            pstmt.setString(2, "123456");

            // 执行查询
            ResultSet rs = pstmt.executeQuery();

            // 遍历结果集并封装为 User 对象
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
                userList.add(user);
            }

            // 输出结果
            for (User u : userList) {
                System.out.println(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        /**
         * 使用 try-with-resources 后，你完全不需要再在外部手动声明 Connection conn = null; 等变量，也不需要手动写 close() 来释放资源。
         * 这是现代 Java 推荐的方式，既简洁又安全。
         * 不需要在try-catch块中手动处理异常，因为try-with-resources语句会自动处理异常。
         * 所以省略了finally块，更简洁。
         * 
         * try (
         *     Connection conn = DriverManager.getConnection(url, user, password);
         *     PreparedStatement pstmt = conn.prepareStatement(sql)
         * )
         * 
         * 这两个对象：
         * 	•	Connection 实现了 AutoCloseable
         * 	•	PreparedStatement 实现了 AutoCloseable
         *
         * 所以即使你没有手动写 conn.close()、pstmt.close()，它们也会自动释放资源，避免连接泄漏。
         */
    }
}
