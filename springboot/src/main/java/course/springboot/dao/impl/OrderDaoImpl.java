package course.springboot.dao.impl;

import course.springboot.dao.IOrderDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements IOrderDao {
    @Override
    public String insertDB(String orderId) {
        return orderId;
    }
}
