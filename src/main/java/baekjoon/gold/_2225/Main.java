package main.java.baekjoon.gold._2225;

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
        int result = execute(n, k);
        System.out.println(result);
    }
    private int execute(int n, int k) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][l]) % 1000000000;
                }
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
