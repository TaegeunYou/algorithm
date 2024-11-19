package main.java.baekjoon.silver._11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = execute(t, arr);
        System.out.println(result);
    }

    private int execute(int n, int[] arr) {
        int[] dp = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && dp[j] > tmp) {
                    tmp = dp[j];
                }
            }
            dp[i] = tmp + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
