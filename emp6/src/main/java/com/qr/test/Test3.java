package com.qr.test;

class ABC {
    int n;
}
public class Test3 {
    static void test(ABC abc) {
        abc.n++;
      //  System.out.println(abc.n);
    }
    public static void main(String[] args) {
        ABC abc = new ABC();
        test(abc);
        System.out.println(abc.n);
    }
}
