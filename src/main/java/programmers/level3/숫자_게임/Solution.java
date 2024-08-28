package main.java.programmers.level3.숫자_게임;

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int bIdx = 0;
        for (int a : A) {
            while (bIdx < B.length) {
                if (B[bIdx++] > a) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}