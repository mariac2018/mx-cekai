package course.springboot.dao;

import course.springboot.bean.Account;

import java.util.List;

public interface AccountDao {
    Account selectByAccountId(String accountId);
    List<Account> selectAll();
    Integer insertAccount(Account account);
}
