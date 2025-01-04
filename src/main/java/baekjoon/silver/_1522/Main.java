package main.java.baekjoon.silver._1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = Integer.MAX_VALUE;
        int countA = (int) str.chars().filter(it -> it == 'a').count();
        int countB = str.length() - countA;
        String tmpStr = str + str;
        for (int i = 0; i < str.length(); i++) {
            int num = (int) tmpStr.substring(i, countA + i).chars().filter(it -> it == 'b').count();
            result = Math.min(result, num);
        }
        for (int i = 0; i < str.length(); i++) {
            int num = (int) tmpStr.substring(i, countB + i).chars().filter(it -> it == 'a').count();
            result = Math.min(result, num);
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
