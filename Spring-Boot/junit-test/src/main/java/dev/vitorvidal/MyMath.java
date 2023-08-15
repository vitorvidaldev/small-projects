package dev.vitorvidal;

public class MyMath {
    public int calculateSum(int[] numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }
}
