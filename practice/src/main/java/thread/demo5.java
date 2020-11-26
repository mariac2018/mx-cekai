package thread;

public class demo5 {
    static int data=0;
    static int type=1;
    private static Object object=new Object();

    public static void main(String[] args) {
        //新建三个线程
        Thread t1=new Thread(()->{
            //谁拿到这把锁，谁就能操作这代码
            synchronized (object){
                while(data<1000){
                    if(type==1){
                        printData();
                        type=2;
                        object.notifyAll();
                    }else{
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });

        Thread t2=new Thread(()->{
            synchronized (object){
                while(data<1000){
                    if(type==2){
                        printData();
                        type=3;
                        object.notifyAll();
                    }else{
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t3=new Thread(()->{
            synchronized (object){
                while(data<1000){
                    if(type==3){
                        printData();
                        type=1;
                        object.notifyAll();
                    }else{
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }


    public static void printData(){
        data++;
        System.out.println("data = " + data+ Thread.currentThread());
    }
}
