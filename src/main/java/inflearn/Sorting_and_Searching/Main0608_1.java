package main.java.inflearn.Sorting_and_Searching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 8 32
 * 23 87 65 12 57 32 99 81
 */
public class Main0608_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int lt = 0;
        int rt = arr.length - 1;
        int answer = -1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] > m) {
                rt = mid - 1;
            } else if (arr[mid] < m) {
                lt = mid + 1;
            } else {
                answer = mid + 1;
                break;
            }
        }
        System.out.println(answer);
    }

}