package main.java.baekjoon.silver._1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            execute(n, arr, a, b);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 20 == 0) {
                sb.append(arr[i]).append("\n");
                continue;
            }
            sb.append(arr[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private void execute(int n, int[] arr, int a, int b) {
        if (a == 1) {
            for (int i = b; i <= n; i += b) {
                arr[i] = 1 - arr[i];
            }
        } else {
            arr[b] = 1 - arr[b];
            for (int i = 1; i <= n; i++) {
                if (b + i <= n && b - i >= 1 && arr[b + i] == arr[b - i]) {
                    arr[b - i] = 1 - arr[b - i];
                    arr[b + i] = 1 - arr[b + i];
                    continue;
                }
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
