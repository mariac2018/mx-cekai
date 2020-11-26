package demo4;

import demo3.BiBiService;
import org.springframework.stereotype.Component;

@Component
public class MiMiServiceImp implements MiMIService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String sayXX(String msg) {
        return "Hi " + this.name + " xx " + msg;
    }
}
