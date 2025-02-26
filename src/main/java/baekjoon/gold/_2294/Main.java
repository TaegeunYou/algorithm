package main.java.baekjoon.gold._2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (!coins.contains(coin)) {
                coins.add(coin);
            }
        }
        int result = execute(coins, k);
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }

    private int execute(List<Integer> coins, int k) {
        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        coins.sort(Comparator.naturalOrder());
        for (int coin : coins) {
            if (coin > k) {
                break;
            }
            dp[coin] = 1;
            for (int i = coin + 1; i <= k; i++) {
                if (dp[i - coin] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[k];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
