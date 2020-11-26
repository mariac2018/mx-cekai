package jdbc;

import java.util.ArrayList;
import java.util.List;

public class ModifyDBApp {
    public static void main(String[] args) {
//        testUpdate();
        testInsert();
//        testDelete();
    }

    public static void testUpdate(){
        String mysql="update tb_user3 set name=? where id=?";
        List paramList=new ArrayList();
        paramList.add("小姐姐");
        paramList.add("2");
        int result=ModifyDB.modify(mysql,paramList);
    }

    public static void testInsert(){
        String mysql="insert into tb_user3 values(?,?,?)";
        List paramList=new ArrayList();
        paramList.add(1);
        paramList.add("小密哥");
        paramList.add(60);
        int result=ModifyDB.modify(mysql,paramList);
    }

    public static void testDelete(){
        String mysql="delete from tb_user3 where id=?";
        List paramList=new ArrayList();
        paramList.add(5);
        int result=ModifyDB.modify(mysql,paramList);
    }
}
