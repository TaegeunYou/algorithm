package main.java.programmers.level3.연속_펄스_부분_수열의_합;

import java.util.Arrays;

class Solution {
    public long solution(int[] sequence) {
        long answer = Integer.MIN_VALUE;
        long sum = 0;
        int[] arr1 = Arrays.copyOf(sequence, sequence.length);
        int[] arr2 = Arrays.copyOf(sequence, sequence.length);
        for (int i = 0; i < arr1.length; i++) {
            if (i % 2 == 0) arr1[i] *= -1;
        }
        for (int i = 0; i < arr2.length; i++) {
            if (i % 2 != 0) arr2[i] *= -1;
        }
        return Math.max(getMaxSum(arr1), getMaxSum(arr2));
    }

    private long getMaxSum(int[] arr) {
        long[] sumMaxArr = new long[arr.length];
        sumMaxArr[0] = arr[0];
        long max = sumMaxArr[0];
        for (int i = 1; i < arr.length; i++) {
            long a = sumMaxArr[i - 1] + arr[i];
            long b = arr[i];
            sumMaxArr[i] = Math.max(a, b);
            max = Math.max(max, sumMaxArr[i]);
        }
        return max;
    }
}