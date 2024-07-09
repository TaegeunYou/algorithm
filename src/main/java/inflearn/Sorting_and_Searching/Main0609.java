package main.java.inflearn.Sorting_and_Searching;

import java.util.*;

/**
 * 9 3
 * 1 2 3 4 5 6 7 8 9
 */
public class Main0609 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = 1, tmp = 0;
            for (int i : arr) {
                tmp += i;
                if (tmp > mid) {
                    cnt++;
                    tmp = i;
                    if (cnt > m) {
                        break;
                    }
                }
            }
            if (cnt <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }

}