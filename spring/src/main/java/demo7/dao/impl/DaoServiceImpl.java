package demo7.dao.impl;

import demo7.dao.DaoService;
import org.springframework.stereotype.Repository;

@Repository
public class DaoServiceImpl implements DaoService {
    @Override
    public void connectDB() {
        System.out.println("connect db " );
    }
}
