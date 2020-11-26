package app.day04;

import obj.Account;
import obj.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDesign {
    static String url = "jdbc:mysql://127.0.0.1:3306/course";
    static String userName = "root";
    static String password = "123456";

    public static void main(String[] args) {
        String sql = "select * from account where id=?";
        List<Integer> paramList = new ArrayList<>();
        paramList.add(5);
        List userList = queryDB(sql, paramList, new UserMapper());
        System.out.println("userList = " + userList);
    }

    //3、jdbc 对查询做一个小小的设计
    public static List queryDB(String sql, List params, RowMapper mapper) {
        List objList = new ArrayList();
        try (Connection connection = DriverManager.getConnection(url, userName, password);) {
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                //解析result
                //抽象成一个接口
                Object obj = mapper.map(rs);
                objList.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objList;
    }

    public static class UserMapper implements RowMapper {
        @Override
        public User map(ResultSet rs) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");

            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setAge(age);

            return user;
        }
    }

    public static class AccountMapper implements RowMapper {
        @Override
        public Account map(ResultSet rs) throws SQLException {
            int id = rs.getInt("id");
            String owner = rs.getString("owner");
            int money = rs.getInt("money");

            Account account = new Account();
            account.setId(id);
            account.setOwner(owner);
            account.setMoney(money);

            return account;
        }
    }


    public interface RowMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }

}
