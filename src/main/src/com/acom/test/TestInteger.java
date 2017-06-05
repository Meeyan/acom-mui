package com.acom.test;

/**
 * Created by zhaojy on 2016/11/28.
 */
public class TestInteger {
    public static void main(String[] args) {
        int a = 80;
        int b = 80;
        if (a == b) {
            System.out.println("11111");
        } else {
            System.out.println("2222");
        }

        Integer aa = 100;
        Integer bb = 100;
        System.out.println(aa.equals(bb));
        if (aa == bb) {
            System.out.println("33333");
        } else {
            System.out.println("44444");
        }
    }
}
