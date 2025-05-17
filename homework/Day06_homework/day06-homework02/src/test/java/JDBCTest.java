import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * 3. 基于AI辅助，通过JDBC程序，基于预编译SQL，执行如下更新语句。 【必须】
 * 备注： user 表，就是课程资料中提供的user表。
 * 将查询的结果，封装到User对象中，并输出到控制台。
 */

public class JDBCTest {

    @Test
    public void testJdbc() throws Exception {
        // 获取链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web01", "root", "12341234");
        // 创建预编译PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement("select id,username,password,name,age from user where age >= ? and id <= ?");
        pstmt.setInt(1, 18);
        pstmt.setInt(2, 4);
        // 执行查询
        ResultSet rs = pstmt.executeQuery();

        ArrayList<User> userlist = new ArrayList<>();
        // 处理结果集
        while (rs.next()) {
            // 创建User对象并设置属性
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            userlist.add(user);
        }
        // 打印User对象
        for (User user : userlist) {
            System.out.println(user);
        }
        // 关闭资源
        rs.close();
        pstmt.close();
        conn.close();
    }

    /**
     * 3. 基于AI辅助，通过JDBC程序，基于预编译SQL，执行如下更新语句。 【必须】
     * 备注： user 表，就是课程资料中提供的user表。
     * update user set password = ? , name = ?, age = ? where id = ? ;
     * <p>
     * 测试参数:
     * password: '666888'
     * name: '关羽'
     * age: 32
     * id: 4
     */
    @Test
    public void testJdbc2() throws Exception {
        // 获取链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web01", "root", "12341234");
        // 创建预编译PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement("update user set password = ? , name = ?, age = ? where id = ?");
        pstmt.setString(1, "666888");
        pstmt.setString(2, "关羽");
        pstmt.setInt(3, 32);
        pstmt.setInt(4, 6);
        // 执行更新
        int update = pstmt.executeUpdate();
        System.out.println("更新了" + update + "行数据");
        // 关闭资源
        pstmt.close();
        conn.close();
        
        
    }
}
