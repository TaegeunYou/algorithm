package main.java.baekjoon.silver._12026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result = execute(n, str);
        System.out.println(result);
    }

    private int execute(int n, String str) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            char tmp = str.charAt(i - 1);
            char before;
            if (tmp == 'O') {
                before = 'B';
            } else if (tmp == 'J') {
                before = 'O';
            } else {
                before = 'J';
            }
            for (int j = 1; j < i; j++) {
                if (dp[j] == -1 || str.charAt(j - 1) != before) {
                    continue;
                }
                int energy = dp[j] + (int) Math.pow(i - j, 2);
                if (dp[i] == -1) {
                    dp[i] = energy;
                    continue;
                }
                dp[i] = Math.min(dp[i], energy);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
