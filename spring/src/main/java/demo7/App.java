package demo7;

import demo7.controller.webController;
import demo7.service.webService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(webConfiguration.class);
        webController controller=context.getBean(webController.class);
        controller.ping();
    }
}
