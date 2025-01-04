package main.java.baekjoon.silver._2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int result = execute(n, d, k, c, arr);
        System.out.println(result);
    }

    private int execute(int n, int d, int k, int c, int[] arr) {
        int[] dp = new int[3001];
        int tmp = 0;
        int rt = k - 1;
        int lt = 0;
        for (int i = lt; i <= rt; i++) {
            int num = arr[i];
            dp[num]++;
            if (dp[num] == 1 && num != c) {
                tmp++;
            }
        }
        int answer = tmp;
        while (rt <= 2 * n) {
            rt++;
            int rtNum = arr[rt % n];
            int ltNum = arr[lt % n];
            dp[rtNum]++;
            if (dp[rtNum] == 1 && rtNum != c) {
                tmp++;
            }
            dp[ltNum]--;
            if (dp[ltNum] == 0 && ltNum != c) {
                tmp--;
            }
            lt++;
            answer = Math.max(answer, tmp);
        }
        return answer + 1;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
