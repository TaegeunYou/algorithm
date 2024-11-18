package main.java.baekjoon.silver._1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int[] dp;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        int result = recursive(n);
        System.out.println(result);
    }

    private int recursive(int x) {
        if (x == 1) {
            return 0;
        }
        if (dp[x] != 0) {
            return dp[x];
        }
        int min = Integer.MAX_VALUE;
        if (x % 3 == 0) {
            min = Math.min(min, recursive(x / 3) + 1);
        }
        if (x % 2 == 0) {
            min = Math.min(min, recursive(x / 2) + 1);
        }
        min = Math.min(min, recursive(x - 1) + 1);
        dp[x] = min;
        return min;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
