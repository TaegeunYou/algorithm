package main.java.inflearn.Array;

import java.util.Scanner;

/**
 * arr
 * 5
 * 2 3 1 7 3
 * 4 1 9 6 8
 * 5 5 2 4 4
 * 6 5 2 6 7
 * 8 4 2 2 2
 */

/**
 * cnt
 *      1반 ~ 9반
 * 1학년
 * 2
 * 3
 * 4
 * 5
 */
public class Main0211 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][5];
        int[][] cnt = new int[5][9];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                cnt[j][arr[i][j]-1]++;
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                answer[i] += cnt[j][arr[i][j]-1];
            }
        }
        int max = 0;
        int answerIdx = -1;
        for (int i = 0; i < n; i++) {
            if (answer[i] > max) {
                max = answer[i];
                answerIdx = i;
            }
        }
        System.out.println(answerIdx + 1);
    }

}