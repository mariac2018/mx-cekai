///**
// * Created by test on 2020/5/28.
// */
//
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @ClassName wcl_vola
// * @Description
// * @Author wuchenlong
// * @Date 2020/5/28 下午2:38
// **/
//public class wcl_vola {
//
//    public static volatile int a = 1;
//    public static volatile boolean flag = true;
//    public static AtomicInteger d = new AtomicInteger(1);
//
//
//
//    public static void main(String[] args) {
////        Runnable runnable1 = new Runnable() {
////            public void run() {
////                printD();
////            }
////        };
////        Runnable runnable2 = new Runnable() {
////            public void run() {
////                printS();
////            }
////        };
////        Thread thread1 = new Thread(runnable1);
////        Thread thread2 = new Thread(runnable2);
////        thread2.start();
////        thread1.start();
//        new Thread(new Runnable() {
//            public void run() {
//                printDNew();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            public void run() {
//                printSNew();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            public void run() {
//                printTNew();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            public void run() {
//                printFNew();
//            }
//        }).start();
//
//    }
//
//    public static void printDNew(){
//        while (d.get() < 1000){
//            if (d.get() % 4 == 1){
//                System.out.println(d.get());
//                d.getAndAdd(1);
//            }
//        }
//    }
//
//    public static void printSNew(){
//        while (d.get() <= 1000){
//            if (d.get() % 4 == 2){
//                System.out.println(d.get());
//                d.getAndAdd(1);
//            }
//        }
//    }
//
//    public static void printTNew(){
//        while (d.get() <  1000){
//            if (d.get() % 4 == 3){
//                System.out.println(d.get());
//                d.getAndAdd(1);
//            }
//        }
//    }
//
//    public static void printFNew(){
//        while (d.get() <= 1000){
//            if (d.get() % 4 == 0){
//                System.out.println(d.get());
//                d.getAndAdd(1);
//            }
//        }
//    }
//
//    public static void printD() {
//        while (a <= 100){
//            if (flag){
//                System.out.println(a);
//                a++;
//                flag = false;
//            }
//        }
//    }
//
//    public static void printS() {
//        while (a <= 100){
//            if (!flag){
//                System.out.println(a);
//                a++;
//                flag = true;
//            }
//        }
//    }
//}