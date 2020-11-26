package jdbc;

import org.assertj.core.util.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class QueryTable {
    static String url = "jdbc:mysql://127.0.0.1:3306/course";
    static String userName = "root";
    static String password = "123456";

    public static void main(String[] args) {
        String sql = "select * from tb_user3";
        List<User> list = queryDB(sql, User.class);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static <T> List<T> queryDB(String sql, Class<T> clazz) {
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            List<T> resultList = Lists.newArrayList();
            //处理结果
            while (rs.next()) {
                //根据class，实例化对象
                T instance = clazz.getDeclaredConstructor().newInstance();
                //循环对象属性，根据对象字段获取数据库值
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    //根据对象的字段名获取
                    Object val = rs.getObject(field.getName());
                    //如果字段是bigInstance  1、mysql类型和java类型有一定区别 因此需要处理
                    // 2、对象的变量名必须和db严格一致
                    if (val instanceof BigInteger) {
                        long val2 = ((BigInteger) val).longValue();
                        field.setAccessible(true);
                        field.set(instance, val2);
                        continue;
                    }
                    //设置字段可访问
                    field.setAccessible(true);
                    field.set(instance, val);
                }
                resultList.add(instance);
            }
            return resultList;
        } catch (SQLException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
