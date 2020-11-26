package course.springboot.controller;

import course.springboot.service.IpingService;
import course.springboot.service.impl.PingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class PingController {
    private static final Logger LOGGER= LoggerFactory.getLogger(PingServiceImpl.class);

    @Autowired
    IpingService ipingService;

    @RequestMapping("/create")
    public String createOrder(String orderId){
        LOGGER.info("controller start");
        Boolean isOk=ipingService.dbOperator(orderId);
        return isOk ? "haha":"failed";
    }

    @RequestMapping("/get")
    public String testOnly(){
        LOGGER.info("controller start");
        return "success";
    }
}
