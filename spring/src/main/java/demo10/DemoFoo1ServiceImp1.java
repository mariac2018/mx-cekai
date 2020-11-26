package demo10;

import org.springframework.stereotype.Service;

@Service
public class DemoFoo1ServiceImp1 implements DemoFoo1Service{
    @Override
    public void run() {
        System.out.println("this = " + this);
    }
}
