package main.java.baekjoon.bronze._23971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = execute(H, W, N, M);
        System.out.println(result);
    }

    private int execute(int h, int w, int n, int m) {
        int a = (h - 1) / (n + 1) + 1;
        int b = (w - 1) / (m + 1) + 1;
        return a * b;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
