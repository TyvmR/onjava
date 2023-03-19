package org.example.onjava.chapter19;

public class StudentGreeting implements Greeting{
    @Override
    public String sayHello() {
        return "Student Say: hello teacher!";
    }
}
