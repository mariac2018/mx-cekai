package demo9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {
        ApplicationContext context=new AnnotationConfigApplicationContext(demo9Configuration.class);

        FileOperator fileOperator=context.getBean(FileOperator.class);
        fileOperator.logFile("hello");

        SocketOperator socketOperator=context.getBean(SocketOperator.class);
        socketOperator.logFile("hello");
    }
}
