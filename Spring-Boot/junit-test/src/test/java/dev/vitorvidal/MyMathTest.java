package dev.vitorvidal;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyMathTest {
    @Test
    void calculateSum() {

        MyMath math = new MyMath();
        int[] numbers = {1, 2, 3};
        int result = math.calculateSum(numbers);

        assertEquals(6, result);
    }

    @Test
    void test() {
        int[] numbers = {};

        MyMath math = new MyMath();
        int result = math.calculateSum(numbers);

        assertEquals(0, result);
    }
}