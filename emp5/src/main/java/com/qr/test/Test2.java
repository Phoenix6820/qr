package com.qr.test;

class A {

    static {
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类动态代码块");
    }
    public A(int a) {
        System.out.println("父类构造方法");
    }


}

public class Test2 extends A{

    static {
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类动态代码块");
    }
    public Test2() {
        super(4);
        System.out.println("子类构造方法");
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        Test2 t1 = new Test2();
    }
}
