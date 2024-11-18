package main.java.baekjoon.bronze._2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = fibo(n);
        System.out.println(result);
    }

    private long fibo(int n) {
        if (n < 2) {
            return n;
        }
        long num1 = 0;
        long num2 = 1;
        for (int i = 2; i <= n; i++) {
            long tmp = num1 + num2;
            num1 = num2;
            num2 = tmp;
        }
        return num2;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
