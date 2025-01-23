package main.java.baekjoon.bronze._13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st1.nextToken());
        int c = Integer.parseInt(st1.nextToken());
        long result = execute(arr, b, c);
        System.out.println(result);
    }

    private long execute(int[] arr, int b, int c) {
        long result = 0;
        result += arr.length;
        for (int i : arr) {
            int remain = i - b;
            if (remain <= 0) {
                continue;
            }
            int tmp = remain / c + (remain % c > 0 ? 1 : 0);
            result += tmp;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
