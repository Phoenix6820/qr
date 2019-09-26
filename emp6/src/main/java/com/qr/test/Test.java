package com.qr.test;

import com.qr.entity.Employee;

public class Test {
    //字符串  equals 比较的是内容是否相等
    // ==  比较的是内存地址是否相等
    public static void main(String[] args) {
//        int n=0;
//        Employee emp=new Employee();
//        String str1 = "abc";
//        String str2 =new String("abc");
//        System.out.println(str1 == str2);
//        System.out.println(str1.equals(str2));

        Integer a =-129;
        Integer b =-129;
        System.out.println(a == b);
        System.out.println(a.equals(b));

    }
}
