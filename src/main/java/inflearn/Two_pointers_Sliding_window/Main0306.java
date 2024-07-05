package main.java.inflearn.Two_pointers_Sliding_window;

import java.util.Scanner;

/**
 * 14 2
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 */
public class Main0306 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        /**
         * 오른쪽으로만 붙이는데
         * 오른쪽에 0 k개까지는 인정
         */
        int max = 0;
        for (int lt = 0; lt < n; lt++) {
            int sum = 0;
            int zeroCnt = 0;
            int rt = lt-1;
            while (zeroCnt <= k && rt < n - 1) {
                if (arr[++rt] == 1) {
                    sum++;
                } else {
                    zeroCnt++;
                    if (zeroCnt <= k) sum++;
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

}