package main.java.baekjoon.silver._1205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        if (n == 0) {
            System.out.println(1);
            return;
        }
        int[] arr = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        int result = execute(arr, n, score, p);
        System.out.println(result);
    }

    private int execute(int[] arr, int n, int score, int p) {
        if (arr.length == p && arr[n - 1] >= score) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            if (score >= arr[i]) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
