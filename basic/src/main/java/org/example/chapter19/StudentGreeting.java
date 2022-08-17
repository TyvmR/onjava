package org.example.chapter19;

public class StudentGreeting implements Greeting{
    @Override
    public String sayHello() {
        return "Student Say: hello teacher!";
    }
}
