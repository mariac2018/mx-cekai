package demo9;

import org.springframework.stereotype.Component;

@Component
public class SocketOperator {

    public void logFile(String msg) throws Exception {
        System.out.println("log msg = " + msg);
    }
}
