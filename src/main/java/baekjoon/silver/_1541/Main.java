package main.java.baekjoon.silver._1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = execute(str);
        System.out.println(result);
    }

    private int execute(String str) {
        if (!str.contains("-")) {
            return getSum(str);
        }
        int idx = str.indexOf('-');
        int plus = getSum(str.substring(0, idx));
        int minus = getSum(str.substring(idx + 1));
        return plus - minus;
    }

    private int getSum(String str) {
        String[] nums = str.replace('+', ' ').replace('-', ' ').split(" ");
        return Arrays.stream(nums).mapToInt(Integer::parseInt).sum();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
