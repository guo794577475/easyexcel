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
        List<String> strings = Arrays.asList("das", "few", "asd", "asdaw");
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        /*for (String s : strings) {
            System.out.println(s);
        }*/
        MyLamda myLamda = s -> System.out.println(s + "yy");
//        myLamda = new MyLambdaImpl();
        myLamda.testLambda("testLambda");

        lambda2();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable1");
            }
        };
        runnable.run();
        Runnable runnable1 = () -> {
            System.out.println("run2");
        };
        runnable1.run();
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable1);
        thread.start();
        thread1.start();
        TitileVO titileVO = null;
        Optional<TitileVO> titileVO1 = Optional.ofNullable(titileVO);
    }


    private void lambda2() {
        System.out.println("================");
        List<String> strings = Arrays.asList("das", "few", "bfew", "asd", "asdaw");
        Collections.sort(strings,(a, b)-> a.compareTo(b));
        for (String s : strings) {
            System.out.println(s);
        }
    }

    private void lambda1() {
        System.out.println("================");
        List<String> strings = Arrays.asList("das", "few", "asd", "asdaw");
        Collections.sort(strings,(Comparator<? super String>) (String a, String b)->{
            return b.compareTo(a);
        }
        );
        for (String s : strings) {
            System.out.println(s);
        }
    }

}
