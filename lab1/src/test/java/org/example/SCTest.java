package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SCTest {
    @Test
    void test1() {
        StringCalculator sc = new StringCalculator();
        assertEquals(7, sc.add("1,6"));
    }

    @Test
    void test2() {
        StringCalculator sc = new StringCalculator();
        assertEquals(0, sc.add(""));
    }

    @Test
    void test3() {
        StringCalculator sc = new StringCalculator();
        assertEquals(4, sc.add("4"));
    }

    @Test
    void test4() {
        StringCalculator sc = new StringCalculator();
        assertEquals(6, sc.add("1,2,3"));
    }

    @Test
    void test5() {
        StringCalculator sc = new StringCalculator();
        assertEquals(6, sc.add("-5,3\\n8"));
    }

    @Test
    void test6() {
        StringCalculator sc = new StringCalculator();
        assertEquals(13, sc.add("//*\\n1,3*9"));
    }

    @Test
    void test7() {
        StringCalculator sc = new StringCalculator();
        assertEquals(1003, sc.add("//*\\n1001\\n3*1000"));
    }

    @Test
    void test8() {
        StringCalculator sc = new StringCalculator();
        assertEquals(17, sc.add("//[***]\\n12***2,3"));
    }

    @Test
    void test9() {
        StringCalculator sc = new StringCalculator();
        assertEquals(66, sc.add("//[**][%%%]\\n11%%%22**33"));
    }
}
