package main.java.baekjoon.silver._1932;

import java.io.*;
import java.util.*;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[250000];
        int[] sum = new int[250000];
        int idx = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
                arr[idx] = Integer.parseInt(st.nextToken());
                if (idx == 0) {
                    continue;
                }
                int left = idx - i;
                int right = idx - i + 1;
                if (j == 0) {
                    sum[idx] = sum[right] + arr[idx];
                } else if (j == i - 1) {
                    sum[idx] = sum[left] + arr[idx];
                } else {
                    sum[idx] = Math.max(sum[left], sum[right]) + arr[idx];
                }
                if (i == n) {
                    result = Math.max(result, sum[idx]);
                }
                idx++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
