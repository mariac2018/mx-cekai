package demo2;

import demo1.HelloService;

public class HeHeServiceImp implements HeHeService {
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
