package main.java.inflearn.Sorting_and_Searching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 8 32
 * 23 87 65 12 57 32 99 81
 */
public class Main0608 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] == m) {
                System.out.println(i + 1);
                break;
            }
        }
    }

}