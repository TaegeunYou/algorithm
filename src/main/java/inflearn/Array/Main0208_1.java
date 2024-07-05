package main.java.inflearn.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5
 * 87 89 92 100 76
 */
public class Main0208_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ints = new int[n];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int tmp = 1;
            for (int j = 0; j < i; j++) {
                if (ints[j] < ints[i]) {
                    answer[j]++;
                } else if (ints[j] > ints[i]) {
                    tmp++;
                }
            }
            answer[i] = tmp;
        }
        System.out.println(Arrays.toString(answer));
    }

}