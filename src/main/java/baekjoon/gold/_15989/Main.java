package main.java.baekjoon.gold._15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int[] nums = {1, 2, 3};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int result = execute(Integer.parseInt(br.readLine()));
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private int execute(int n) {
        int[] dp = new int[n + 3];
        for (int num : nums) {
            dp[num] += 1;
            for (int i = num + 1; i <= n; i++) {
                dp[i] += dp[i - num];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
