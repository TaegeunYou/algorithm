package main.java.programmers.level2.최솟값_만들기;

import java.util.Arrays;

/**
 * [1, 4, 2]	[5, 4, 4]
 */
class Solution {

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (A[i] * B[A.length - i - 1]);
        }
        return sum;
    }
}
