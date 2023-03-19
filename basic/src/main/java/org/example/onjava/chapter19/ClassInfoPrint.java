package org.example.onjava.chapter19;



interface D {}

interface E {}

interface F {}


class Toy{
    public Toy(){

    }

    public Toy(int i){

    }
}

class FancyToy extends Toy implements D,E,F{

}

public class ClassInfoPrint {

    static void printInfo(Class cc){
        System.out.println("================");
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
        System.out.println("================");
        System.out.println();
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("org.example.chapter19.FancyToy");
        } catch(ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for(Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // 对应类要有public的无参构造器：
            obj = up.newInstance();
        } catch(Exception e) {
            throw new
                    RuntimeException("Cannot instantiate");
        }
        printInfo(obj.getClass());
    }

}
