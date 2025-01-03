package main.java.baekjoon.gold._5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int MAX_NUM = 20;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long result = execute(n, arr);
        System.out.println(result);
        br.close();
    }

    private long execute(int n, int[] arr) {
        long[][] dp = new long[n][MAX_NUM + 1];
        dp[1][arr[1]] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= MAX_NUM; j++) {
                if (dp[i - 1][j] == 0) {
                    continue;
                }
                if (j - arr[i] >= 0) {
                    dp[i][j - arr[i]] += dp[i - 1][j];
                }
                if (j + arr[i] <= MAX_NUM) {
                    dp[i][j + arr[i]] += dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][arr[n]];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
