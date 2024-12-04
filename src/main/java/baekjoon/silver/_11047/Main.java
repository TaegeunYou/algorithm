package main.java.baekjoon.silver._11047;

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

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int result = execute(k, coins);
        System.out.println(result);
    }

    private int execute(int k, int[] coins) {
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            if (k >= coin) {
                count += k / coin;
                k %= coin;
            }
            if (k == 0) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
