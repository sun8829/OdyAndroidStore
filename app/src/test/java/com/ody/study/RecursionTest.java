package com.ody.study;


import org.junit.Test;

/**
 * Created by sunhuahui on 2017/7/26.
 */

public class RecursionTest {

    @Test
    public void factorialTest() {
        System.out.println("结果:" + factorial(4));
    }

    private int factorial(int src) {
        if (src <= 1) {
            return 1;
        } else {
            System.out.println("过程" + src);
            return src * factorial(src - 1);
        }
    }
}
