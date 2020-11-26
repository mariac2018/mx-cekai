package course.springboot;

import course.springboot.bean.Account;
import course.springboot.dao.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJdbc {
    @Autowired
    AccountDao accountDao;

    @Test
    public void testSelectByAccountId(){
        Account account=accountDao.selectByAccountId("6");
        System.out.println("account = " + account);
    }

    @Test
    public void testSelectAll(){
        List<Account> account=accountDao.selectAll();
        System.out.println("account = " + account);
    }
}
