package demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("demo2/beans.xml");
        HeHeService service= context.getBean(HeHeService.class);
        String s=service.sayHi("HHH");
        System.out.println("s = " + s);
    }
}
