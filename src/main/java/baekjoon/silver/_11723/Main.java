package main.java.baekjoon.silver._11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[21];
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            String[] split = input.split(" ");
            String command = split[0];
            if (command.equals("add")) {
                int num = Integer.parseInt(split[1]);
                arr[num] = 1;
            } else if (command.equals("remove")) {
                int num = Integer.parseInt(split[1]);
                arr[num] = 0;
            } else if (command.equals("check")) {
                int num = Integer.parseInt(split[1]);
                sb.append(arr[num]).append("\n");
            } else if (command.equals("toggle")) {
                int num = Integer.parseInt(split[1]);
                arr[num] = Math.abs(arr[num] - 1);
            } else if (command.equals("all")) {
                Arrays.fill(arr, 1);
            } else if (command.equals("empty")) {
                Arrays.fill(arr, 0);
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
