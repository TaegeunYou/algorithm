package main.java.programmers.level3.거스름돈;

class Solution2 {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        for (int m : money) {
            dp[m]++;
            for (int i = 1; i <= n; i++) {
                if (i - m <= 0) continue;
                dp[i] += dp[i - m];
            }
        }
        return dp[n];
    }
}