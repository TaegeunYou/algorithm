package main.java.inflearn.Recursive_Tree_Graph;

import java.util.Scanner;

/**
 * 259 5
 * 81
 * 58
 * 42
 * 33
 * 61
 */
public class Main0802 {

    static int n, c;
    static int[] arr;

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        c = in.nextInt();
        n = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int idx, int sum) {
        if (idx == n) {
            if (sum <= c && sum > answer) {
                answer = sum;
            }
//            if (sum <= c) {
//                answer = Math.max(answer, sum);
//            }
            return;
        }
        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
    }

}