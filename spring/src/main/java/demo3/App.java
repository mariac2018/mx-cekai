package demo3;

import demo2.HeHeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("demo3/beans.xml");
        BiBiService service= context.getBean(BiBiService.class);
        String s=service.sayHi("HHH");
        System.out.println("s = " + s);
    }
}
