package com.luo.mao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luoq
 * @version 1.0
 * @date 2020/8/17 10:19
 */
public class Lamda {

    public static void main(String[] args) {
        ReentrantLock
       /* new AbsInter() {
            public void getMyname() {
                System.out.println("maomimimi");
            }
        }.getMyname();*/

        Map<String, Integer> items = new HashMap<>();
        int a = 100 << 2;
        System.out.println(a);
        //new AbsInter(()-> System.out.printf("1")).getMyname();
       // new Thread(()->System.out.println("maomimimi")).start();
        //new Thread(() -> System.out.println("It's a lambda function!")).start();
      getCat(1, () ->
      {
          System.out.println("Lamda.main");
          return "qianqian dedamaomi ";
      });
    }


    public static  void  getCat(int a,AbsInter a1){

        System.out.println("Lamda.getCat"+a1.getMyname());
    }

}
