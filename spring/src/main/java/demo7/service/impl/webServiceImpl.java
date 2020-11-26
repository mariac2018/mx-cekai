package demo7.service.impl;

import demo7.dao.DaoService;
import demo7.service.webService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class webServiceImpl implements webService {
    @Autowired
    DaoService daoService;

    @Override
    public void webTest() {
        daoService.connectDB();
        System.out.println(" new web hahhahahh... ");
    }
}
