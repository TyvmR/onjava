package org.example.onjava.chapter07.father;


public class Father {

    private void doing(){
        System.out.println(" father say hello ");
    }


    static class Son  {
        public static void main(String[] args) {
//            Father father = new Son();
//            father.doing();
        }


        void add(){
//            doing();
        }
    }




}
