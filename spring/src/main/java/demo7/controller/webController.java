package demo7.controller;

import demo7.service.webService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class webController {
    @Autowired
    private webService service;

    public void ping(){
        service.webTest();
    }
}
