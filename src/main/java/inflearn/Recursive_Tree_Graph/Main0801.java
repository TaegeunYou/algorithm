package main.java.inflearn.Recursive_Tree_Graph;

import java.util.Scanner;

/**
 * 6
 * 1 3 5 6 7 10
 */
public class Main0801 {

    static int n;
    static int sum = 0;
    static String answer = "NO";

    static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int idx) {
        if (idx == n) {
            if (sum == 0) {
                answer = "YES";
            }
        } else {
            sum += arr[idx];
            dfs(idx + 1);
            sum -= (arr[idx] * 2);
            dfs(idx + 1);
            sum += arr[idx];
        }
    }
}