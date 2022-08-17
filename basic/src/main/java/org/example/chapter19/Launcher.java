package org.example.chapter19;

import java.lang.reflect.Proxy;

public class Launcher {


        public static void main(String[] args) {
            Greeting greeting = new StudentGreeting();
            DynamicProxyhandler dynamicProxyhandler = new DynamicProxyhandler(greeting);
            Class<?>[] interfaces = greeting.getClass().getInterfaces();
            Greeting greetingproxy = (Greeting) Proxy.newProxyInstance(Launcher.class.getClassLoader(), interfaces, dynamicProxyhandler);
            String s = greetingproxy.sayHello();
            System.out.println(s);

        }
}
