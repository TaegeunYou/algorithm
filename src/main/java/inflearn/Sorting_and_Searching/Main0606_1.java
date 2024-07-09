package main.java.inflearn.Sorting_and_Searching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 9
 * 120 125 152 130 135 135 143 127 160
 */
public class Main0606_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                System.out.print(i + 1 + " ");
            }
        }
    }

}