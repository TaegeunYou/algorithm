package main.java.baekjoon.gold._11058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = execute(n);
        System.out.println(result);
        br.close();
    }
    
    private long execute(int n) {
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i <= 3) {
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; i - j - 1 > 0; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - (j + 1)]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
