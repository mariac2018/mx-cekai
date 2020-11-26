package course.springboot.dao.impl;

import course.springboot.bean.Account;
import course.springboot.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByAccountId(String accountId) {
        List<Account> accounts= jdbcTemplate.query("select * from account where `id`=?",new Object[]{accountId},new BeanPropertyRowMapper<>(Account.class));
        System.out.println("accounts = " + accounts);
        return accounts.get(0);
    }

    @Override
    public List<Account> selectAll() {
        return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Integer insertAccount(Account account) {
        return null;
    }
}
