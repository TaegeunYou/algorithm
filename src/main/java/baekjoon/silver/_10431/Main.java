package main.java.baekjoon.silver._10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int result = execute(arr);
            System.out.println(num + " " + result);
        }
    }

    private int execute(int[] arr) {
        int result = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
            list.sort(Comparator.reverseOrder());
            result += list.indexOf(i);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
