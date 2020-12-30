package com.example.demo.service.impl;

import com.example.demo.service.MyLamda;

public class MyLambdaImpl implements MyLamda {
    @Override
    public void testLambda(String s) {
        System.out.println(s);
    }
}
