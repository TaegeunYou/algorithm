package main.java.baekjoon.silver._1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        int result = execute(n, s, m, arr);
        System.out.println(result);
    }

    private int execute(int n, int s, int m, int[] arr) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, -1);
        dp[s] = 0;

        for (int i = 0; i < n; i++) {
            int vol = arr[i];
            ArrayList<Integer> nums = new ArrayList<>();
            for (int j = 0; j <= m; j++) {
                if (dp[j] == i) {
                    if (j + vol <= m) {
                        nums.add(j + vol);
                    }
                    if (j - vol >= 0) {
                        nums.add(j - vol);
                    }
                }
            }
            for (int num : nums) {
                dp[num] = i + 1;
            }
        }

        int max = -1;
        for (int i = 0; i <= m; i++) {
            if (dp[i] == n) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        new Main1().solution();
    }
}
