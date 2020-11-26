package demo3;

import org.springframework.stereotype.Component;

@Component
public class BiBiServiceImp implements BiBiService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String sayHi(String msg) {
        return "Hi " + this.name + " say " + msg;
    }
}
