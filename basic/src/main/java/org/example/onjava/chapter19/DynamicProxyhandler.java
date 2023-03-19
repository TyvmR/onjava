package org.example.onjava.chapter19;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class DynamicProxyhandler implements InvocationHandler {

    private Object target;


    public DynamicProxyhandler(Object proxy){
        this.target = proxy;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");

        Object invoke = method.invoke(target, args);
        System.out.println(invoke);

        System.out.println("after");

        return invoke;

    }

}


