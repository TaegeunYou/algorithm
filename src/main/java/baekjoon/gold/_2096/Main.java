package main.java.baekjoon.gold._2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }
        //max
        int[][] maxDp = new int[n][3];
        maxDp[0][0] = arr[0][0];
        maxDp[0][1] = arr[0][1];
        maxDp[0][2] = arr[0][2];
        for (int i = 1; i < n; i++) {
            //0
            maxDp[i][0] = arr[i][0] + Math.max(maxDp[i - 1][0], maxDp[i - 1][1]);
            //1
            maxDp[i][1] = arr[i][1] + Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]);
            //2
            maxDp[i][2] = arr[i][2] + Math.max(maxDp[i - 1][1], maxDp[i - 1][2]);
        }
        int answerMax = Math.max(Math.max(maxDp[n - 1][0], maxDp[n - 1][1]), maxDp[n - 1][2]);
        //min
        int[][] minDp = new int[n][3];
        minDp[0][0] = arr[0][0];
        minDp[0][1] = arr[0][1];
        minDp[0][2] = arr[0][2];
        for (int i = 1; i < n; i++) {
            //0
            minDp[i][0] = arr[i][0] + Math.min(minDp[i - 1][0], minDp[i - 1][1]);
            //1
            minDp[i][1] = arr[i][1] + Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]);
            //2
            minDp[i][2] = arr[i][2] + Math.min(minDp[i - 1][1], minDp[i - 1][2]);
        }
        int answerMin = Math.min(Math.min(minDp[n - 1][0], minDp[n - 1][1]), minDp[n - 1][2]);
        System.out.println(answerMax + " " + answerMin);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
