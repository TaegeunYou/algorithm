package main.java.programmers.level2.행렬의_곱셈;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        //arr1의 행 + arr2의 열
        // 4 3 - 3 2 => 4 2
        for (int k = 0; k < arr2[0].length; k++) {
            for (int i = 0; i < arr1.length; i++) {
                int sum = 0;
                for (int j = 0; j < arr1[0].length; j++) {
                    sum += (arr1[i][j] * arr2[j][k]);
                }
                answer[i][k] = sum;
            }
        }
        return answer;
    }
}