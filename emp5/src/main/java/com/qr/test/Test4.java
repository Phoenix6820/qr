package com.qr.test;

public class Test4 {
    static int test() {
        int a = 5;
        try {
            a = 6;
            return a;
        } catch (Exception e) {
            a = 7;
        } finally {
            a = 8;
            System.out.println("finally"+a);
        }
        return 0;
    }
    public static void main(String[] args) {
        int a = test();
        System.out.println(a);
    }
}
