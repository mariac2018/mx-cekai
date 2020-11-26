package java8;

import java.util.Comparator;
import java.util.function.Function;

public class lampdaDemo3 {
    public static void foo1(){
        //静态方法的调用 Integer.compare()  可以省略参数、参数类型
        //引用式的写法
        Comparator<Integer> comparator=Integer::compare;
        //非静态方法也可以这么写
        // ::前面表示类，后面表示方法
        //接口有参数时可以这么写
        Function<String,String> function= String::toUpperCase;
        Function<String,Integer> function2= Integer::parseInt;
        Function<String,String> function3= str->str.toUpperCase();

    }
}
