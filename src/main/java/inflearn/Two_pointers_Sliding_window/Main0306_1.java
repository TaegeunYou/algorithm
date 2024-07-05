package main.java.inflearn.Two_pointers_Sliding_window;

import java.util.Scanner;

/**
 * 14 2
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 */
public class Main0306_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int lt = 0, zeroCnt = 0, max = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                zeroCnt++;
                while (zeroCnt > k && lt <= rt) {
                    if (arr[lt++] == 0) {
                        zeroCnt--;
                    }
                }
            }
            max = Math.max(max, rt - lt + 1);
        }
        System.out.println(max);
    }

}