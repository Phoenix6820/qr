package com.qr.test;

import java.util.HashMap;
import java.util.Set;

class A {

    protected double test(int i, int j) {
        return 0;
    }

}

public class B extends A {

    public double test(int i, int j) {
        HashMap hm = new HashMap<>();

        hm.keySet();
        Set set = hm.entrySet();
        one:
        while (true) {

          two:  while (true) {

                break one;
            }

        }


        return 0;
    }
}
