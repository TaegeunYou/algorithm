package main.java.programmers.level2.숫자_카드_나누기;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        for (int i : getCommonDivisor(arrayA)) {
            boolean flag = true;
            for (int j : arrayB) {
                if (j / i > 0 && j % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer = Math.max(answer, i);
        }
        for (int i : getCommonDivisor(arrayB)) {
            boolean flag = true;
            for (int j : arrayA) {
                if (j / i > 0  && j % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer = Math.max(answer, i);
        }
        return answer;
    }

    private ArrayList<Integer> getCommonDivisor(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= min; i++) {
            boolean flag = true;
            for (int j : arr) {
                if (j % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) result.add(i);
        }
        return result;
    }

}