package org.example.onjava.chapter08;

public class Son extends Father {


    private String hobby;


    public Son(int age){
        super(12,"21");
        this.hobby = hobby;
    }

    public void sayHello(){
        System.out.println(" say hello ");
    }


    public static void main(String[] args) {
        Son son = new Son(32);

    }


}
