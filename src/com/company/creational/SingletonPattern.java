package com.company.creational;

public class SingletonPattern {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Singleton.getInstance())).start();
        new Thread(() -> System.out.println(Singleton.getInstance())).start();
    }
}

class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        Singleton helper = instance;
        if (helper != null)
            return helper;
        synchronized (Singleton.class) {
            if (helper == null) {
                helper = instance = new Singleton();
            }
            return helper;
        }
    }
}