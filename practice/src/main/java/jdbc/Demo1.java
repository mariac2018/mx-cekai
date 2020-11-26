package jdbc;


import java.sql.*;

public class Demo1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/course";
        String userName = "root";
        String password = "123456";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1、建立连接 mysql是属于tcp的请求 建立连接也是一个对象
            connection = DriverManager.getConnection(url, userName, password);
            String sql = "select * from tb_user3";
            //2.1预编译sql
            statement = connection.prepareStatement(sql);
            //2.2执行查询
            resultSet = statement.executeQuery();
            //2.3处理结果集
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                //索引从1开始，不是0，不建议用这种方式
                int age = resultSet.getInt(3);
                System.out.println("Userid=" + userId + ";UserName=" + name + ";age=" + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
