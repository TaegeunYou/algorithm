package main.java.baekjoon.gold._2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int result = execute(arr, k);
        System.out.println(result);
    }

    private int execute(int[] arr, int k) {
        int[] dp = new int[k + 1];
        Arrays.sort(arr);
        for (int coin : arr) {
            for (int i = coin; i <= k; i++) {
                if (coin == i) {
                    dp[i]++;
                }
                dp[i] += dp[i - coin];
            }
        }
        return dp[k];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
