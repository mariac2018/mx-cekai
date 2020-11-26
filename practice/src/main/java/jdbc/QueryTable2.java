package jdbc;

import org.assertj.core.util.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryTable2 {
    static String url = "jdbc:mysql://127.0.0.1:3306/course";
    static String userName = "root";
    static String password = "123456";

    public static void main(String[] args) {
        String sql = "select * from tb_user3 where name=?";
        List param=new ArrayList();
        param.add("小逼仔");
        List<User> list = queryDBMapper(sql, param,new AccountMapper());
        for (Object o : list) {
            System.out.println(o);
        }
    }

    static class AccountMapper implements RowMapper<User>{
        @Override
        public User map(ResultSet resultSet) throws SQLException {
            Long id=resultSet.getLong("id");
            String name=resultSet.getString("name");
            Integer age=resultSet.getInt("age");
            return new User(id,name,age);
        }
    }


    interface RowMapper<T>{
        T map(ResultSet resultSet) throws SQLException;
    }

    //用反射会有的问题：1、mysql类型和java类型有一定区别 因此需要处理
    // 2、对象的变量名必须和db严格一致
    //使用road mapper来做最终的解决方法
    public static <T> List<T> queryDBMapper(String sql, List<T> params,RowMapper<T> mapper) {
        List<T> resultList = Lists.newArrayList();
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            //设置变量
            for(int i=0;i<params.size();i++){
                statement.setObject(i+1,params.get(i));
            }
            ResultSet rs = statement.executeQuery();

            //处理结果
            while (rs.next()) {
                //处理结果这边是个抽象，因此用接口方式来处理
                T obj= mapper.map(rs);
                resultList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
