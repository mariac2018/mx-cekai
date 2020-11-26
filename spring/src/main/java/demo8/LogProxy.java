package demo8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogProxy {
    //用反射来实现动态代理
    public static <T> T getProxyInstance(T instance,InvocationHandler invocation){
//        return (T) Proxy.newProxyInstance(instance.getClass().getClassLoader(),instance.getClass().getInterfaces(), (proxy, method, args) -> {
//            System.out.println("proxy before log");
//            Object result=method.invoke(instance,args);
//            System.out.println("proxy after log");
//            return result;
//        });

        return (T) Proxy.newProxyInstance(instance.getClass().getClassLoader(),instance.getClass().getInterfaces(), invocation);
    }
}
