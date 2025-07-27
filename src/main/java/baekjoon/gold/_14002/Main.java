package main.java.baekjoon.gold._14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        String[] dpStr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            dpStr[i] = "" + arr[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    dpStr[i] = dpStr[j] + " " + arr[i];
                }
            }
        }
        int answer = 0;
        String answerStr = "";
        for (int i = 0; i < n; i++) {
            if (dp[i] > answer) {
                answer = dp[i];
                answerStr = dpStr[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n").append(answerStr);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
