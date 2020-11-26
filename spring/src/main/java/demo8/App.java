package demo8;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        //新建代理的实例
        //ClassLoader loader： 类加载器：基于class字节码（通过对象的类加载器来获得）复制成一个新的类，根据这个类去创建一个新的对象，这个对象就是代理对象
        //Class<?>[] interfaces： jdk代理的典型使用，基于接口
        //InvocationHandler h：回调处理器，表示代理的能力
        FileOperator fileOperator=new FileOperator();
        InvokeHandlerImp invokeHandle=new InvokeHandlerImp(fileOperator);
        Operator2 operator=LogProxy.getProxyInstance(fileOperator,invokeHandle);
        operator.eat();
    }
}
