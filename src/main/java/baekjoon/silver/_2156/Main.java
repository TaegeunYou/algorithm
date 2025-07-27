package main.java.baekjoon.silver._2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[Math.max(3, n + 1)];
        int[] dp = new int[Math.max(3, n + 1)];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        int answer = dp[2];
        for (int i = 3; i <= n; i++) {
            int a = dp[i - 2] + arr[i];
            int b = dp[i - 1];
            int c = dp[i - 3] + arr[i - 1] + arr[i];
            dp[i] = Math.max(Math.max(a, b), c);
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
