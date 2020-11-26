package app.day04;

import obj.User;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.TreeSet;

public class DBOperator {
    static String url = "jdbc:mysql://127.0.0.1:3306/course";
    static String userName = "root";
    static String password = "123456";

    public static void main(String[] args) {
        dbTest();
    }

    //2、本地创建一个文件 ，内容格式为每行:id,name,age
    //如: 1, 张三, 23
    //解析此文件，解析后将内容存储进数据库。自行建数据库，表等
    //附加能力:
    //对数据做去重处理，即id,name,age三个数据完全一样认为是相同的
    //对数据排序,将数据排序后存储进数据库
    public static void dbTest() {
        //读取文件并解析成treeSet
        TreeSet<User> userTreeSet;
        String filePath = "D:\\work\\code\\mx-cekai\\homework\\src\\main\\java\\data\\userData";
        userTreeSet = readFile(filePath);
        System.out.println("userTreeSet = " + userTreeSet);

        //将数据存储到数据库中
        insertDB(userTreeSet);

    }

    //读文件
    private static TreeSet<User> readFile(String path) {
        File file = new File(path);
        TreeSet<User> userTreeSet = new TreeSet<>(new UserCompartor());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String len;
            while ((len = reader.readLine()) != null) {
                //解析文本转换插入set
                User user = parseFile(len);
                userTreeSet.add(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return userTreeSet;
    }

    //解析字符串->User对象
    private static User parseFile(String str) {
        User user = new User();
        String[] arrays = StringUtils.split(str, ",");
        user.setId(Integer.parseInt(arrays[0]));
        user.setName(arrays[1]);
        user.setAge(Integer.parseInt(arrays[2]));
        return user;
    }

    //实现Compartor接口
    private static class UserCompartor implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            if (o1.getId() != o2.getId()) {
                return o1.getId() - o2.getId();
            }
            //如果id相等,用name来比较
            if (o1.getName() != o2.getName()) {
                return o1.getName().compareTo(o2.getName());
            }
            //如果name也相等，则用age比较
            return o1.getAge() - o2.getAge();
        }
    }

    //将treeset数据插入数据库
    private static void insertDB(TreeSet<User> userTree) {
        PreparedStatement statement = null;
        try (Connection connection = DriverManager.getConnection(url, userName, password);) {
            String sql = "insert into tb_user values (?,?,?)";
            StringBuilder sb = new StringBuilder();
            sb.append(sql);
            for (int i = 1; i < userTree.size(); i++) {
                sb.append(",(?,?,?)");
            }
            sql = sb.toString();
            statement = connection.prepareStatement(sql);

            int index = 0;
            for (User user : userTree) {
                statement.setInt(++index, user.getId());
                statement.setString(++index, user.getName());
                statement.setInt(++index, user.getAge());
            }

            int rs = statement.executeUpdate();
            System.out.println("rs = " + rs);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
