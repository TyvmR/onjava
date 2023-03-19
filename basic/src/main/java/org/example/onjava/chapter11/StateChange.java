package org.example.onjava.chapter11;

public class StateChange {

    int i  = 0 ;

    public void increatement(){
        i++;
    }


    class InnerStateChange{

        public void print(){
            System.out.println(i);
        }
    }


    //内部类与共享外部类状态
    public static void main(String[] args) {
        StateChange stateChange = new StateChange();
        StateChange.InnerStateChange innerStateChange = stateChange.new InnerStateChange();
        innerStateChange.print();
        stateChange.increatement();
        innerStateChange.print();
        InnerStateChange innerStateChange1 = stateChange.new InnerStateChange();
        innerStateChange1.print();
    }


}
