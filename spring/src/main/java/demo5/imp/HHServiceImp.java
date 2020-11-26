package demo5.imp;

import demo4.MiMIService;
import demo5.HHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class HHServiceImp implements HHService {
    private String name;
    @Autowired
    private LocalDateTime plsuOneDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String sayHH(String msg) {
        return "Hi " + this.name + " HH " + msg+plsuOneDay;
    }
}
