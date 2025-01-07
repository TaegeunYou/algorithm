package main.java.baekjoon.gold._14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st1.nextToken());
        int w = Integer.parseInt(st1.nextToken());
        int[] arr = new int[w];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        int result = execute(arr);
        System.out.println(result);
    }

    private int execute(int[] arr) {
        int[] lt = new int[arr.length];
        int[] rt = new int[arr.length];
        int ltMax = 0;
        int rtMax = 0;
        for (int i = 0; i < arr.length; i++) {
            lt[i] = ltMax;
            ltMax = Math.max(ltMax, arr[i]);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            rt[i] = rtMax;
            rtMax = Math.max(rtMax, arr[i]);
        }
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = Math.min(lt[i], rt[i]);
            if (tmp > arr[i]) {
                answer += tmp - arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
