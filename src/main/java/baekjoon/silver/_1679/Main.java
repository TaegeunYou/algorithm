package main.java.baekjoon.silver._1679;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[100001];
        for (int i = 0; i <= 100000; i++) {
            dp[i] = Math.abs(n - i);
        }
        for (int i = n + 1; i <= k; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            } else {
                dp[i] = Math.min(dp[i], dp[(i + 1) / 2] + 2);
            }
        }
        System.out.println(dp[k]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
