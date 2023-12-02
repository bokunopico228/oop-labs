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
}
