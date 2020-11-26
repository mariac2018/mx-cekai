package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class reflectDemo3 {
    //解决之前jmeter工具用到的问题
    public static void main(String[] args) {
        Class<PayService> payServiceClass=PayService.class;
        //通过对象获取方法
        Method[] methods=payServiceClass.getDeclaredMethods();
        Method method=methods[0];
        //通过方法获得参数类型
        Class<?>[] paramTypeClass=method.getParameterTypes(); //泛型，不确定返回的类型是什么就用?
        //获得第一个参数的类对象PayRequest
        Class<?> paramType1=paramTypeClass[0];
        //根据类对象获得参数
        Field[] fields=paramType1.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            Field field=fields[i];
            String name=field.getName(); //字段名
            Class<?> fieldType=field.getType(); //字段类
        }




    }
}
