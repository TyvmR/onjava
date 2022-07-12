package org.example.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

import java.lang.reflect.InvocationTargetException;

public class HelloWorld {


    public String saySth(String msg){
        System.out.println(msg);
        return msg + "1";
    }


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloWorld.class);
        enhancer.setCallback(new ClassBackImpl());
        HelloWorld o = (HelloWorld)enhancer.create();
        Object oU = 1234;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        FastClass fastClass = FastClass.create(classLoader, HelloWorld.class);
        FastMethod saySth = fastClass.getMethod("saySth", new Class[]{String.class});
        try {
            Object invoke = saySth.invoke(o, new Object[]{oU});
            System.out.println(invoke);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }

}
