package course.springboot.controller;

import com.google.common.base.Strings;
import course.springboot.bean.PayInfo;
import course.springboot.bean.RetMsg;
import course.springboot.service.impl.PingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("pay")
@RestController
public class PayController {
    private final static Logger LOGGER= LoggerFactory.getLogger(PayController.class);
    @RequestMapping("foo1")
    public String foo1(@RequestParam(value="payId3",required = true) String payId){
        return "success "+payId;
    }

    //rest的风格
    @RequestMapping("foo2/{payId}")
    public String foo2(@PathVariable(value = "payId") String payId){
        return "success "+payId;
    }

    //设置默认值
    @RequestMapping("foo3")
    public String foo3(@RequestParam(required = false,defaultValue="123456") String payId){
        return "success "+payId;
    }

    @RequestMapping("foo4")
    public String foo4(String payId){
        try{
            if(Strings.isNullOrEmpty(payId))
            {
                throw new IllegalArgumentException();
            }
            return "success "+payId;
        }catch(IllegalArgumentException e){
            return "error: "+e.toString();
        }
    }

    @RequestMapping(value = "foo5",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public RetMsg foo5(@RequestBody PayInfo payInfo){
        LOGGER.info("foo5 start,payInfo={}",payInfo);
        return RetMsg.buildSuccessMsg(payInfo.getOrderId());
    }
}
