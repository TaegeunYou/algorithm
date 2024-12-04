package main.java.baekjoon.silver._11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = execute(n, arr);
        System.out.println(result);
    }

    private int execute(int n, int[] arr) {
        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result += arr[j];
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
