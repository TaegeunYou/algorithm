package main.java.baekjoon.gold._13144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long result = execute(n, arr);
        System.out.println(result);
    }

    private long execute(int n, int[] arr) {
        long[] check = new long[100001];
        Arrays.fill(check, -1);
        long result = 0;
        long tmp = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (check[num] != -1) {
                result = result + get(i - tmp) - get(i - (Math.max(tmp, check[num] + 1)));
                tmp = Math.max(tmp, check[num] + 1);
            }
            check[num] = i;
        }
        result += get(arr.length - 1 - tmp + 1);
        return result;
    }


    private long get(long num) {
        return num * (num + 1) / 2;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
