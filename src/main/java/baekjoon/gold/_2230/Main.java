package main.java.baekjoon.gold._2230;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int result = execute(n, m, arr);
        System.out.println(result);
    }

    private int execute(int n, int m, int[] arr) {
        int lt = 0;
        int rt = 0;
        int answer = Integer.MAX_VALUE;
        while (lt <= rt && rt < n) {
            while (rt < n - 1 && arr[rt] - arr[lt] < m) {
                rt++;
            }
            int diff = arr[rt] - arr[lt];
            if (diff >= m) {
                answer = Math.min(answer, diff);
            }
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
