package com.example.demo.service;

@FunctionalInterface
public interface MyLamda {
    /**
     * asda
     */
    void testLambda(String s);

    default void default1(){
        System.out.println("default1");
    }

    default void default2(){
        System.out.println("default2");
    }

    static void default3(){
        System.out.println("static default");
    }
}
