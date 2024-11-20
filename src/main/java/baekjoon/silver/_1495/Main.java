package main.java.baekjoon.silver._1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//브루트포스 - 메모리초과
public class Main {
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
        int dpSize = (int) Math.pow(2, n + 1);
        Integer[] dp = new Integer[dpSize];
        Arrays.fill(dp, null);
        dp[1] = s;
        for (int i = 1; i < dpSize / 2; i++) {
            Integer tmp = dp[i];
            if (tmp == null) {
                continue;
            }
            int tmpMove = arr[log2(i)];
            if (tmp - tmpMove >= 0) {
                dp[i * 2] = tmp - tmpMove;
            }
            if (tmp + tmpMove <= m) {
                dp[i * 2 + 1] = tmp + tmpMove;
            }
        }

        int result = -1;
        for (int i = dpSize / 2; i < dpSize; i++) {
            if (dp[i] != null) {
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    private int log2(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
