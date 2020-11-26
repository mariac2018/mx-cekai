package demo8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvokeHandlerImp<T> implements InvocationHandler {
    T instance;

    public InvokeHandlerImp(T instance) {
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy before log");
        Object result=method.invoke(instance,args);
        System.out.println("proxy after log");
        return result;
    }
}
