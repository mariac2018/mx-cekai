package singleton;
/**
 * 饿汉模式
 * */
//设置为final，类不能被继承
public final class Demo1 {
    //先把构造器私有化
    private Demo1(){

    }

    //先建一个静态变量，值为new Demo1
    //这个方法的缺点是类一加载就创建了Demo1对象，如果创建对象比较耗资源的话，这个方法不是很好
    private static final Demo1 INSTANCE=new Demo1();

    //用getInstance返回这个值
    public static Demo1 getInstance(){
        return INSTANCE;
    }
}
