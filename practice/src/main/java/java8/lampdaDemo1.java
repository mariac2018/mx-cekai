package java8;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public class lampdaDemo1 {
    public static void main(String[] args) {

    }

    public static void foo1(){
        //内部类的方式
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("args = hahahhahahh");
            }
        };
    }

    public static void foo2(){
        //->左边表示参数列表，如果没有参数时要写()，有多个参数时也要，只有一个参数时可以不写
        // 参数类型可以根据接口重写的方法自动获取，因此不需要写参数类型；
        // 以下Comparator是基于类型推断，从<Integer>推断到o1,o2的方法
        // 接口只有一个抽象方法时才能用lampda写法
        // {}，只有一句语句时可以写，有多个语句时不可以写
        Runnable r2=()->System.out.println("test");
        Comparator<Integer> comparator=(o1,o2)->0;
        BiBi bb=a->System.out.println("bb");

        Function<String,String> func=str->{
            System.out.println("str = " + str);
            return str.toUpperCase();
        };

    }

    public static void foo3(){
        Foo foo=(i1,time,mapping)->null;

    }

    interface Foo{
        String foo(Integer i1, Date time, Map<String,String> mapping);
    }

    @FunctionalInterface
    public interface BiBi{
        void test1(Integer a);

    }
}
