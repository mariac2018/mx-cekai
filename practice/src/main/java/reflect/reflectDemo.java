package reflect;

import oob.Car;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class reflectDemo{
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Class<Car> clz= Car.class;
        //获得方法
        clz.getMethods();
        //获得私有方法
        Method[] methonds=clz.getDeclaredMethods();
        Method method=clz.getDeclaredMethod("test");

        //基于class，获取属性的描述
        Field[] f1=clz.getFields();
        Field[] f2=clz.getDeclaredFields();
        Field f3=clz.getDeclaredField("test");

        //基于class，获取构造器
        clz.getConstructor(String.class,Integer.class); //通过参数类型获取构造器
        clz.getConstructors();
        clz.getDeclaredConstructor();
    }
}
