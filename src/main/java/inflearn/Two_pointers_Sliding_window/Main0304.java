package main.java.inflearn.Two_pointers_Sliding_window;

import java.util.Scanner;

/**
 * 8 6
 * 1 2 1 3 1 1 1 2
 */
public class Main0304 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int sum = 0;
        int lt = 0;
        int rt = 0;
        int answer = 0;
        while (rt < n) {
            while (sum > m) {
                sum -= arr[lt++];
            }
            while (sum < m) {
                sum += arr[rt++];
            }
            if (sum == m) {
                answer++;
                if (++rt < n) {
                    sum += (arr[rt] - arr[lt++]);
                }
            }
        }
        System.out.println(answer);
    }

}