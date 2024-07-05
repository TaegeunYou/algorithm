package main.java.inflearn.Two_pointers_Sliding_window;

import java.util.Scanner;

/**
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 */
public class Main0301 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = in.nextInt();
        }
        int [] answer = new int [n + m];
        int np = 0;
        int mp = 0;
        for (int i = 0; i < n + m; i++) {
            if (mp == m || (np < n && nArr[np] < mArr[mp])) {
                answer[i] = nArr[np++];
            } else {
                answer[i] = mArr[mp++];
            }
        }
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

}