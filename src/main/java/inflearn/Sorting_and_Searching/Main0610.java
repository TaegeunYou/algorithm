package main.java.inflearn.Sorting_and_Searching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5 3
 * 1 2 8 4 9
 */
public class Main0610 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int rt = arr[n - 1] - arr[0];
        int lt = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int tmp = Math.abs(arr[i] - arr[i+1]);
            if (tmp < lt) {
                lt = tmp;
            }
        }
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = 1;
            int tmp = 0;
            for (int i = 1; i < n; i++) {
                int diff = arr[i] - arr[i - 1];
                tmp += diff;
                if (tmp > mid) {
                    cnt++;
                    tmp = 0;
                }
            }
            if (cnt < m) {     //불가능
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }

}