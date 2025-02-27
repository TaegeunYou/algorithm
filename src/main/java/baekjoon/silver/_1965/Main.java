package main.java.baekjoon.silver._1965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = execute(arr);
        System.out.println(result);
    }

    private int execute(int[] arr) {
        int[] dp = new int[arr.length];
        int answer = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++)  {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    answer = Math.max(answer, dp[i]);
                }
            }
        }
        return dp[dp.length - 1];
    }

    private int execute2(int[] arr) {
        int[] dp = new int[arr.length];
        int lastIdx = -1;
        for (int i : arr) {
            if (lastIdx == -1) {
                dp[0] = i;
                lastIdx++;
                continue;
            }
            int idx = bs(dp, i, 0, lastIdx);
            lastIdx = Math.max(lastIdx, idx);
            dp[idx] = i;
        }
        return lastIdx + 1;
    }

    private int bs(int[] dp, int num, int lt, int rt) {
        if (num > dp[rt]) {
            return rt + 1;
        }
        if (lt >= rt) {
            return rt;
        }
        int mid = (lt + rt) / 2;
        if (dp[mid] < num) {
            return bs(dp, num, mid + 1, rt);
        } else {
            return bs(dp, num, lt, mid);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
