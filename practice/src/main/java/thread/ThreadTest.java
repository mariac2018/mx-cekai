package thread;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t1=new Thread();

        Thread t2=new Thread(new BiBIRun());  //Runnable是接口 线程和任务分离

        //或者通过new 继承Thread的对象（线程和任务放一起）


    }

     static class BiBIRun implements Runnable{

         @Override
         public void run() {
             System.out.println("bibi run run run");
         }
     }
}
