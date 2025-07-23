package main.java.baekjoon.silver._1912;

import java.io.*;
import java.util.*;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int answer = 0;
        int max = Integer.MIN_VALUE;
        boolean isAllMinus = true;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp >= 0) {
                isAllMinus = false;
            }
            max = Math.max(max, tmp);
            int tmpSum = sum + tmp;
            if (tmpSum < 0) {
                sum = 0;
            } else {
                sum = sum + tmp;
            }
            answer = Math.max(answer, sum);
        }
        if (isAllMinus) {
            System.out.println(max);
        } else {
            System.out.println(answer);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
