package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class lampdaDemo2 {
    public static void main(String[] args) {
        //函数式接口类型，java8在java.util.function下定义了一些函数式接口
        // 1、转化型 java.util.function.Function R apply(T t);将输入转化成其他类型
        Function<String,Integer> function= Integer::parseInt;
        // 2、消费型 java.util.function.Consumer void accept(T t); 处理数据没有返回
        Consumer<String> consumer= System.out::println;
        // 3、供给型 java.util.function.Supplier;没有参数，只有返回值
        Supplier<String> supplier=()->Integer.toString(123);
        // 4、断言型 java.util.function.Predicate; 传入参数，返回布尔型，断言结果
        Predicate<Integer> predicate=a->a>100;

    }



}
