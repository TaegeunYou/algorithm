package main.java.baekjoon.silver._2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    int[] arr;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        arr = new int[t + 3];
        for (int i = 0; i < t; i++) {
            arr[i + 1] = Integer.parseInt(br.readLine());
        }
        int result = execute(t);
        System.out.println(result);
    }

    private int execute(int n) {
        int[] dp = new int[n + 3];
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        for (int i = 3; i <= n; i++) {
            int a = dp[i - 2];
            int b = dp[i - 3] + arr[i - 1];
            dp[i] = Math.max(a, b) + arr[i];
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        new Main1().solution();
    }
}
