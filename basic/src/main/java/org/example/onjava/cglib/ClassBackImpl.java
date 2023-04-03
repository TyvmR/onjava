package org.example.onjava.cglib;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ClassBackImpl implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> parameterType = parameterTypes[0];
        String simpleName = parameterType.getSimpleName();
        Object arg = args[0];
        String typeName = arg.getClass().getTypeName();
        System.out.println(" Method parameterTypes is" + simpleName);
        System.out.println(" Method intur parameterType is" + typeName);
        Object o = proxy.invokeSuper(obj, args);
        return o;
    }
}
