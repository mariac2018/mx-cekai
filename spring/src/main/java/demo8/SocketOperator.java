package demo8;

public class SocketOperator implements Operator{
    public void openSocket(){
        System.out.println("open socket...");

    }

    @Override
    public void op(String path) {
        System.out.println("socket operator");

    }
}
