package demo1;

public class Demo1 {
    public static void main(String[] args) {
        HelloService service=new HelloServiceImpl();
        String a=service.sayHi("xiaomige");
    }
}
