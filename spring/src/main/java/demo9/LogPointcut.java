package demo9;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogPointcut {

    @Pointcut("execution(public * demo9.So*.*(..))")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void logBefore(){
        //织入
        System.out.println("log before...");
    }

    @After("pointcut()")
    public void logAfter(){
        System.out.println("log after...");
    }

    @AfterThrowing("pointcut()")
    public void logAfterThrowing(){
        System.out.println("throwing after...");
    }
}
