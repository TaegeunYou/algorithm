package main.java.baekjoon.gold._1106;

import java.io.*;
import java.util.*;
import java.io.InputStreamReader;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[100001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int client = Integer.parseInt(st.nextToken());
            for (int j = cost; j < dp.length; j++) {
                int a = dp[j - cost] + client;
                int b = dp[j];
                dp[j] = Math.max(a, b);
            }
        }
        int answer = -1;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] >= c) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
