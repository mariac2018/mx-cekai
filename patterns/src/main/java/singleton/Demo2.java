package singleton;
/**
 * 懒汉模式
 * */
public final class Demo2 {
    private Demo2(){

    }

    private static volatile Demo2 INSTANCE;

    //synchronized和volatile主要是防止多线程时线程安全问题
    //get instance的时候才去创建对象，缺点是需要判断比较多且要加同步锁
    public static Demo2 getInstance(){
        if(INSTANCE==null){
            synchronized (INSTANCE.getClass()){
                if(INSTANCE==null){
                    INSTANCE=new Demo2();
                }
            }
        }
        return INSTANCE;
    }
}
