package course.springboot.service.impl;

import course.springboot.dao.IOrderDao;
import course.springboot.service.IpingService;
import lombok.extern.flogger.Flogger;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PingServiceImpl implements IpingService {
    private static final Logger LOGGER= LoggerFactory.getLogger(PingServiceImpl.class);

    @Autowired
    IOrderDao iOrderDao;

    @Override
    public Boolean dbOperator(String orderId) {
        LOGGER.info("insert db success " + orderId);
        return iOrderDao.insertDB(orderId)!=""?true:false;
    }
}
