package app.day03;

import obj.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day03 {
    public static void main(String[] args) {
        List<User> userList=new ArrayList<>();
        readDir("D:\\work\\code\\homework\\homework\\hahahaha",3,userList);
        System.out.println("userList = " + userList);
        userList.sort(new UserComparator());
        System.out.println("userList = " + userList);
//        copyFile("D:\\work\\code\\homework\\homework\\src\\data\\file1.java", "D:\\work\\code\\homework\\homework\\src\\data\\file2");
    }

    //1、递归读取文件夹下的全部文件,目录层次结构不确定
    //loopCount控制递归的深度
    private static void readDir(String dir,int loopCount,List userList) {
        File file = new File(dir);

        //获得文件夹里的所有目录
        //String[] paths = file.list();
        File[] files=file.listFiles();

        //如果文件夹下目录为空，返回
        if(files==null||files.length==0){
            System.out.println("文件为空"+file.getAbsolutePath());
            return;
        }
        //循环读取文件夹里的所有文件
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                List fileUsers=readFile(files[i]);
                userList.addAll(fileUsers);
                continue;
            }
            //如果是目录的话，需要再读取下面的文件
            if(loopCount<=0){
                return;
            }
            loopCount--;
            readDir(files[i].getAbsolutePath(),loopCount,userList);
        }
    }

    private static List<User> readFile(File file) {
        BufferedReader br = null;
        String line;
        List<User> userList=new ArrayList<>();
        try {
            System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
            br = new BufferedReader(new FileReader(file));
            System.out.println("开始读取文件======"+file.getAbsolutePath());
            while ((line = br.readLine()) != null) {
                User user=parseFile(line);
                userList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return userList;
    }

    private static User parseFile(String str){
        String[] arrays=str.split(" ");
        System.out.println("arrays = " + arrays);

        Integer id=Integer.parseInt(arrays[0]);
        String name=arrays[1];
        Integer age=Integer.parseInt(arrays[2]);

        User user=new User();
        user.setAge(age);
        user.setId(id);
        user.setName(name);

        return user;
    }

    private static class UserComparator implements Comparator<User> {
        //1是大于，0是等于，-1是小于
        @Override
        public int compare(User o1,User o2) {
            return o1.getId()-o2.getId();
        }
    }


    //2、文件复制，请考虑异常场景
    public static void copyFile(String src, String dst) {
        File srcFile = new File(src);
        FileReader fr = null;
        FileWriter fw = null;
        StringBuilder sb = new StringBuilder();
        //读文件
        try {
            fr = new FileReader(srcFile);
            char[] chars = new char[128];
            int len;
            while ((len = fr.read(chars)) != -1) {
                String s = new String(chars, 0, len);
                sb.append(s);
            }
        } catch (IOException e) {
            System.out.println("error while reading file");
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //写文件
        try {
            fw = new FileWriter(dst);
            fw.write(sb.toString());
        } catch (IOException e) {
            System.out.println("写文件时出错");
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
