package main.java.inflearn.Sorting_and_Searching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5 9
 * 1 2 3 2 6 2 3 5 7
 */
public class Main0604_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < m; i++) {
            int tmp = in.nextInt();
            int pos = -1;
            for (int j = 0; j < n; j++) {
                if (arr[j] == tmp) {
                    pos = j;
                }
            }
            if (pos == -1) {
                for (int j = n - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
            } else {
                for (int j = pos; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
            }
            arr[0] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }

}