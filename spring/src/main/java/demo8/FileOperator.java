package demo8;

public class FileOperator implements Operator,Operator2{
    public void openFile(){
        System.out.println("open file...");
    }

    @Override
    public void op(String path) {
        System.out.println("file operator "+path);

    }

    @Override
    public void eat() {
        System.out.println("hahhhhhahahahh");
    }
}
