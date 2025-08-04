package main.java.baekjoon.gold._1744;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp > 0) {
                positive.add(tmp);
            } else if (tmp < 0) {
                negative.add(tmp);
            } else {
                zeroCount++;
            }
        }
        int answer = 0;
        positive.sort(Comparator.reverseOrder());
        negative.sort(Comparator.naturalOrder());
        for (int i = 0; i < positive.size(); i += 2) {
            int a = positive.get(i);
            if (i + 1 < positive.size()) {
                int b = positive.get(i + 1);
                if (a == 1 || b == 1) {
                    answer += a;
                    answer += b;
                } else {
                    answer += a * b;
                }
                continue;
            }
            answer += a;
        }
        for (int i = 0; i < negative.size(); i += 2) {
            int a = negative.get(i);
            if (i + 1 < negative.size()) {
                int b = negative.get(i + 1);
                answer += a * b;
            }
        }
        if (negative.size() % 2 == 1) {
            if (zeroCount == 0) {
                answer += negative.get(negative.size() - 1);
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
