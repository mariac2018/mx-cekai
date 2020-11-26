package demo4;

import demo3.BiBiService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(MiMiConfiguration.class);
        MiMIService service= context.getBean(MiMIService.class);
        String s=service.sayXX("HHH");
        System.out.println("s = " + s);
    }
}
