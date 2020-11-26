package demo6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(DogConfiguration.class);
        DogService dogService1=context.getBean(DogService.class);
        DogService dogService2=context.getBean(DogService.class);
        DogService dogService3=context.getBean(DogService.class);
        System.out.println("dogService1 = " + dogService1);
        System.out.println("dogService2 = " + dogService2);
        System.out.println("dogService3 = " + dogService3);

        //dogService1.dogBark("xiaomige");
    }
}
