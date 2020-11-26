package jdbc;

import java.sql.*;
import java.util.List;

public class ModifyDB {
    static String url = "jdbc:mysql://127.0.0.1:3306/course";
    static String userName = "root";
    static String password = "123456";

    //修改的一个接口
    public static Integer modify(String mysql, List param) {
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement statement = connection.prepareStatement(mysql);) {
            for (int i = 0; i < param.size(); i++) {
                statement.setObject(i + 1, param.get(i));
            }
            Integer index = statement.executeUpdate();
            System.out.println(index);
            return index;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
