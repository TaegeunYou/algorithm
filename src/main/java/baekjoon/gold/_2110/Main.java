package main.java.baekjoon.gold._2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int result = execute(c, arr);
        System.out.println(result);
    }

    private int execute(int c, int[] arr) {
        Arrays.sort(arr);
        int min = 1;
        int max = arr[arr.length - 1] - arr[0];
        while (min != max) {
            int mid = (min + max) / 2 + 1;
            if (check(mid, arr, c)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return max;
    }

    private boolean check(int distance, int[] arr, int c) {
        int result = 1;
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - tmp >= distance) {
                result++;
                tmp = arr[i];
            }
        }
        return result >= c;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
