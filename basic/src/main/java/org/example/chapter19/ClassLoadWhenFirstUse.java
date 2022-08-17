package org.example.chapter19;


    class A {
        static {
            System.out.println("A  Loaded");
        }
    }


    class B {
        static {
            System.out.println("B loaded");
        }
    }


    class C {
        static {
            System.out.println("C loaded");
        }
    }

    public class ClassLoadWhenFirstUse{
        public static void main(String[] args) {
            new A();
            try {
                //此处存在副作用
                Class.forName("org.example.chapter19.B");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

