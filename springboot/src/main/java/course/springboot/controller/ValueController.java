package course.springboot.controller;

import cn.hutool.db.ds.pooled.DbConfig;
import course.springboot.bean.DbConfigInfo;
import course.springboot.bean.PayInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("value")
@RestController
public class ValueController {
    private final static Logger LOGGER= LoggerFactory.getLogger(PayController.class);
//    @Value("${xixi.haha}")
//    private String var;

    @Autowired
    private PayInfo payInfo;

    @Autowired
    private DbConfigInfo dbConfigInfo;

//    @RequestMapping("foo1")
//    public String foo1(){
//        LOGGER.info("foo6 start");
//        return "success "+var;
//    }

    @RequestMapping("foo2")
    public String foo2(){
        LOGGER.info("foo6 start");
        return "success "+payInfo;
    }

    @RequestMapping("foo3")
    public String foo3(){
        LOGGER.info("foo6 start");
        return "success "+dbConfigInfo;
    }
}
