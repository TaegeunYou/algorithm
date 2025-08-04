package main.java.baekjoon.silver._2302;

import java.io.*;
import java.util.*;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        int arrPointer = 0;
        int tmpCount = 0;
        for (int i = 1; i <= n; i++) {
            if (arrPointer < arr.length && arr[arrPointer] == i) {
                arrPointer++;
                if (tmpCount == 0) {
                    continue;
                }
                list.add(tmpCount);
                tmpCount = 0;
                continue;
            }
            tmpCount++;
        }
        if (tmpCount != 0) {
            list.add(tmpCount);
        }
        int[] dp = new int[41];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int answer = 1;
        for (int i : list) {
            answer *= dp[i];
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
