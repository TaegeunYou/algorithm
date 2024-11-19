package main.java.baekjoon.gold._15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Consult> consults = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            consults.add(new Consult(i + 1, a, b));
        }
        int result = execute(n, consults);
        System.out.println(result);
    }

    private int execute(int n, List<Consult> consults) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int today = i + 1;
            if (i - 1 >= 0) {
                dp[i] = dp[i - 1];
            }
            int j = Math.max(0, i - 50);
            for (; j <= i; j++) {
                Consult tmp = consults.get(j);
                if (tmp.day + tmp.time - 1 == today) {
                    int before = j - 1 < 0 ? 0 : dp[j - 1];
                    dp[i] = Math.max(dp[i], before + tmp.price);
                }
            }
        }
        return dp[n - 1];
    }

    private class Consult {
        int day;
        int time;
        int price;

        public Consult(int day, int time, int price) {
            this.day = day;
            this.time = time;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
