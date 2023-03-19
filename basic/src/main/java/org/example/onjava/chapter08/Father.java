package org.example.onjava.chapter08;

public class Father {

    private int age;
    private String name;


    public Father(){
        System.out.println("无参构造");
    }

    public Father(int age,String name){
        System.out.println("有参构造");
        this.age = age;
        this.name = name;
    }



}
