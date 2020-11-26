package demo5;

import demo5.conf.HHConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(HHConfiguration.class);
        HHService service= context.getBean(HHService.class);
        String s=service.sayHH("HHH");
        System.out.println("s = " + s);
    }
}
