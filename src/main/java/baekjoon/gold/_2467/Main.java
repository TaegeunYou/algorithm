package main.java.baekjoon.gold._2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        String result = execute(arr);
        System.out.println(result);
    }

    private String execute(Integer[] arr) {
        Arrays.sort(arr, Comparator.comparing(Math::abs));
        int diff = Integer.MAX_VALUE;
        Integer a = null;
        Integer b = null;
        for (int i = 0; i < arr.length - 1; i++) {
            int tmp = Math.abs(arr[i] + arr[i + 1]);
            if (tmp < diff) {
                a = arr[i];
                b = arr[i + 1];
                diff = tmp;
            }
        }
        return Math.min(a, b) + " " + Math.max(a, b);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
