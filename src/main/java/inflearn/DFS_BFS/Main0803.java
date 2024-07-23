package main.java.inflearn.DFS_BFS;

import java.util.Scanner;

/**
 * 5 20
 * 10 5
 * 25 12
 * 15 8
 * 6 3
 * 7 4
 */
public class Main0803 {

    static int n;
    static int m;
    static int[][] arr;
    static int totalScore;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        dfs(0, 0, 0);
        System.out.println(totalScore);
    }

    static void dfs(int idx, int score, int time) {
        if (time > m) return;
        if (idx == n) {
            totalScore = Math.max(totalScore, score);
            return;
        }
        dfs(idx + 1, score + arr[idx][0], time + arr[idx][1]);
        dfs(idx + 1, score, time);
    }


}