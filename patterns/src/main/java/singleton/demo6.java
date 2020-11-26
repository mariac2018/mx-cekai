package singleton;

public class demo6 {
        private demo6(){

            }
            //虚拟机帮我们保证是单例的，类加载的时候只加载一个类
            private static class Inner{
                private static final demo6 INSTANCE=new demo6();
            }
            //调用of方法的时候才会创建，不需要像懒汉模式一样去加同步锁各种判断
            public static demo6 of(){
                demo6 instance=Inner.INSTANCE;
                return instance;
            }

}
