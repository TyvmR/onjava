package org.example.geetime.concurrency;

import java.util.concurrent.CopyOnWriteArrayList;

public class Chapter29 {


    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        ThreadLocal tk = new ThreadLocal();
        tk.set("dd");
    }
}
