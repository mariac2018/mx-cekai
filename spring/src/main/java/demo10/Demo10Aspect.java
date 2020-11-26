package demo10;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Demo10Aspect {
    @Pointcut("execution(public * demo10.*.*(..))")
    public void cirlePoint(){
    }

    @Around("cirlePoint()")
    public Object circle(ProceedingJoinPoint point) throws Exception {
        try {
            System.out.println("before point" );
            Object result=point.proceed();
            System.out.println("after point");
            return result;
        } catch (Throwable throwable) {
            System.out.println("exception point");
            throw new Exception(throwable);
        }finally{
            System.out.println("finally point");
        }


    }
}
