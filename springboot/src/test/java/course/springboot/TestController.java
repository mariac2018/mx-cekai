package course.springboot;

import course.springboot.controller.PayController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController {
    @Autowired
    PayController payController;

    @Test
    public void testFoo4(){
        String resp=payController.foo4("12345");
        System.out.println("resp = " + resp);
    }
}
