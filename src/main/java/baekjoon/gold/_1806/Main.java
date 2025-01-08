package main.java.baekjoon.gold._1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int s = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        int result = execute(n, s, arr);
        System.out.println(result);
    }

    private int execute(int n, int s, int[] arr) {
        int lengthMin = Integer.MAX_VALUE;
        int lt = 0;
        int rt = 0;
        int sum = arr[lt];
        while (lt < n && rt < n) {
            if (sum >= s) {
                lengthMin = Math.min(lengthMin, rt - lt + 1);
                if (lengthMin <= 1) {
                    return 1;
                }
                sum -= arr[lt];
                lt++;
                continue;
            }
            rt++;
            if (rt == n) {
                continue;
            }
            sum += arr[rt];
        }
        if (lengthMin == Integer.MAX_VALUE) {
            return 0;
        }
        return lengthMin;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
