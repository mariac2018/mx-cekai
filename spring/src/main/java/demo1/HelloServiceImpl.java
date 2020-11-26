package demo1;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String msg) {
        return "hi"+msg;
    }
}
