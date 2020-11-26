package reflect;

import oob.Car;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class reflectDemo2 {
    public static void main(String[] args) {
        testReflectMethods();
    }

    private static boolean isObjectMethod(Method method) {
        Class<Object> objClass = Object.class;
        for (Method objMethod : objClass.getMethods()) {
            if (objMethod.getName().equals(method.getName())) {
                return true;
            }
        }
        return false;
    }

    private static void testReflectMethods() {
        Class<Car> clz = Car.class;
//        Method[] methods = clz.getDeclaredMethods();
        Method[] methods = clz.getMethods();
        for (Method method : methods) {
            if (isObjectMethod(method)) {
                System.out.println("对象方法=" + method);
            }
            String methodName = method.getName();
            int parameterCount = method.getParameterCount(); //获取方法参数个数
            Parameter[] parameters = method.getParameters();
            Class<?>[] parameterTypes = method.getParameterTypes(); //获取方法的参数类型列表
            String parameterTypesStr = serParameters(parameterTypes);
            System.out.println("方法参数类型=" + parameterTypesStr);
            Class<?> returnTypes = method.getReturnType(); //获取返回值类型

            int modifiers = method.getModifiers(); //获取修饰值
            boolean isPrivate = Modifier.isPrivate(modifiers);
            boolean isStatic = Modifier.isStatic(modifiers);

            System.out.println(String.format("方法名=%s,方法参数个数=%d,返回值类型=%s,是否私有=%b,是否静态=%b", methodName, parameterCount, returnTypes.getName(), isPrivate, isStatic));
        }

    }

    //序列化方法参数名,转换成String
    public static String serParameters(Class<?>[] parameterTypes) {
        if (parameterTypes.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parameterTypes.length; i++) {
            sb.append(parameterTypes[i].getName()).append(",");
        }
        return sb.toString();
    }
}
