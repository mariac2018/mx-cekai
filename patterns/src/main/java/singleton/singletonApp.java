package singleton;

public class singletonApp {
    public static void main(String[] args) {
        foo2();
    }

    private static void foo1(){
        Demo2 demo1=Demo2.getInstance();
        System.out.println("demo1 = " + demo1);
        Demo2 demo2=Demo2.getInstance();
        System.out.println("demo2 = " + demo2);
        Demo2 demo3=Demo2.getInstance();
        System.out.println("demo3 = " + demo3);
        Demo2 demo4=Demo2.getInstance();
        System.out.println("demo4 = " + demo4);
    }

    private static void foo2(){
        Demo3 demo1=Demo3.of();
        System.out.println("demo3 = " + demo1);
        Demo3 demo2=Demo3.of();
        System.out.println("demo2 = " + demo2);
        Demo3 demo3=Demo3.of();
        System.out.println("demo3 = " + demo3);
        Demo3 demo4=Demo3.of();
        System.out.println("demo4 = " + demo4);
    }
}
