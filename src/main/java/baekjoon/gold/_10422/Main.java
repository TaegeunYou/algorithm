package main.java.baekjoon.gold._10422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1000000007;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int L = Integer.parseInt(br.readLine());
            int result = execute(L);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }

    private int execute(int L) {
        if (L % 2 != 0) {
            return 0;
        }
        long[] dp = new long[L + 1];
        dp[0] = 1;
        for (int i = 2; i <= L; i += 2) {
            long sum = 0;
            int total = i - 2;
            for (int j = 0; j <= total; j += 2) {
                sum += ((dp[j] * dp[total - j]) % MOD);
            }
            dp[i] = sum % MOD;
        }
        return (int) dp[L];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
