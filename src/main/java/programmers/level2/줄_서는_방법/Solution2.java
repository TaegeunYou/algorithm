package main.java.programmers.level2.줄_서는_방법;

import java.util.ArrayList;
import java.util.Arrays;

class Solution2 {

    long[] facto = new long[21];

    public int[] solution(int n, long k) {
        /**
         * 3명 -> 3 * 2 * 1
         * 4명 -> 4 * 3 * 2 * 1
         * n명 -> n * n-1 * n-2 ...
         *
         *
         * 3명 경우
         * 1이 맨앞인 경우 : 2! 개
         * 2이 맨앞인 경우 : 2! 개
         *
         * n명일 경우
         * 1이 맨앞인 경우 : n-1 ! 개
         * 2가 맨앞인 경우 : n-1 ! 개
         */
        int N = n;
        ArrayList<Long> answers = new ArrayList<>();
        while (answers.size() < N) {
            long facto = facto(n - 1);
            long l = k / facto;
            if (k % facto == 0) l--;
            k -= (facto * l);
            answers.add(l + 1);
            n--;
        }
        int[] ch = new int[N + 1];
        int idx = 0;
        int[] a = new int[N];
        for (long l : answers) {
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 0) count++;
                if (count == l) {
                    ch[i] = 1;
                    a[idx++] = i;
                    break;
                }
            }
        }
        return a;
    }

    private long facto(int num) {
        if (facto[num] != 0) return facto[num];
        if (num <= 1) return 1;
        return facto[num] = num * facto(num - 1);
    }

    public static void main(String[] args) {
        int[] solution = new Solution2().solution(20, 2432902008176640000L);
        System.out.println(Arrays.toString(solution));
    }

}