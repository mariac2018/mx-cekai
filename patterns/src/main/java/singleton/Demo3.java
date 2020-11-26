package singleton;

/**
 * 方法3：内部类的方式 -->推荐
 */
public final class Demo3 {
    private Demo3(){

    }
    //虚拟机帮我们保证是单例的，类加载的时候只加载一个类
    private static class Inner{
        private static final Demo3 INSTANCE=new Demo3();
    }
    //调用of方法的时候才会创建，不需要像懒汉模式一样去加同步锁各种判断
    public static Demo3 of(){
        Demo3 instance=Inner.INSTANCE;
        return instance;
    }


}
