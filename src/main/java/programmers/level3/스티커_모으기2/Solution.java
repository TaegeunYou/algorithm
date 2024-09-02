package main.java.programmers.level3.스티커_모으기2;

import java.util.Arrays;

class Solution {
    public int solution(int sticker[]) {
        if (sticker.length <= 2) return Arrays.stream(sticker).max().getAsInt();
        int[] arr1 = new int[sticker.length - 1];
        int[] arr2 = new int[sticker.length - 1];
        for (int i = 0; i < sticker.length - 1; i++) {
            arr1[i] = sticker[i];
        }
        for (int i = 1; i < sticker.length; i++) {
            arr2[i - 1] = sticker[i];
        }
        return Math.max(execute(arr1), execute(arr2));
    }

    private int execute(int sticker[]) {
        int n2 = sticker[0];
        int n1 = Math.max(sticker[0], sticker[1]);
        for (int i = 2; i < sticker.length; i++) {
            if (n2 + sticker[i] > n1) {
                int tmp = n2 + sticker[i];
                n2 = n1;
                n1 = tmp;
            } else {
                n2 = n1;
            }
        }
        return Math.max(n1, n2);
    }

}