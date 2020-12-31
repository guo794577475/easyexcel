package com.example.demo;

import com.example.demo.service.MyLamda;
import com.example.demo.service.impl.MyLambdaImpl;
import com.example.demo.vo.TitileVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Function;

@SpringBootTest
class ExcelApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("================");
        int a =5;
        a<<=2;
        System.out.println(a<<=2);
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 13; i++) {
            System.out.println("`````");
            map.put("a" +i, "" + i);
        }
    }


}
