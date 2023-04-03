package org.example.onjava.chapter19;


import java.util.ArrayList;
import java.util.List;

class  A1 {

}


class  A2 extends A1{

}


public class GenraicClass {


    public static void main(String[] args) {
        List<? super Number> numbers = new ArrayList<>();
//        numbers.add(new A1());

    }




}
