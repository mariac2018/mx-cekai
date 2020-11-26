package demo10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(Demo10Configuration.class);
        DemoFoo1Service demoFoo1Service=context.getBean(DemoFoo1Service.class);
        demoFoo1Service.run();
    }
}
