package main.java.baekjoon.silver._1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] aArr = new int[n];
        int[] bArr = new int[n];
        StringTokenizer sta = new StringTokenizer(br.readLine());
        StringTokenizer stb = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aArr[i] = Integer.parseInt(sta.nextToken());
        }
        for (int i = 0; i < n; i++) {
            bArr[i] = Integer.parseInt(stb.nextToken());
        }
        int result = execute(n, aArr, bArr);
        System.out.println(result);
    }

    private int execute(int n, int[] aArr, int[] bArr) {
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += aArr[i] * bArr[n - i - 1];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
