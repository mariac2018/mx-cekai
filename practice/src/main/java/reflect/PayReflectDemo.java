package reflect;

import java.lang.reflect.Method;

public class PayReflectDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String className="D:\\work\\code\\homework\\homework\\src\\reflect\\PayRequest.java";
        //通过serviceName获得class对象
        Class<?> unKnowClass=Class.forName(className);
        Class<?> payClz=PayService.class;
        Method[] methods=payClz.getDeclaredMethods();

        for(int i=0;i<methods.length;i++){
            Method method=methods[i];
            Class<?>[] parameterTypes=method.getParameterTypes();
            for(int j=0;j<parameterTypes.length;j++){
                String paramType=parameterTypes[i].getName();
            }
        }
    }
}
