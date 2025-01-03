package main.java.baekjoon.silver._20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        int result = execute(n, k, arr);
        System.out.println(result);
    }

    private int execute(int n, int k, int[] arr) {
        int lt = 0;
        int rt = 0;
        int[] state = new int[100001];
        state[arr[lt]] = 1;
        int result = -1;
        while (lt < n) {
            if (state[arr[rt]] > k) {
                state[arr[lt]]--;
                lt++;
            } else {
                rt++;
                if (rt >= n) {
                    break;
                }
                int tmp = arr[rt];
                state[tmp]++;
            }
            if (state[arr[rt]] <= k) {  //가능한 경우
                result = Math.max(result, rt - lt + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
