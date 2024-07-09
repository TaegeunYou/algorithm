package main.java.inflearn.Sorting_and_Searching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5
 * 2 7
 * 1 3
 * 1 2
 * 2 5
 * 3 6
 */
public class Main0607 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt() + " " + in.nextInt();
        }
        Arrays.sort(arr);
        for (String s : arr) {
            System.out.println(s);
        }
    }

}