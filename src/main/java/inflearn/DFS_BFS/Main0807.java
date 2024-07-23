package main.java.inflearn.DFS_BFS;

import java.util.Scanner;

/**
 * 5 3
 */
class Main0807 {

    static int[][] arr = new int[34][34];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        int answer = dfs(n , r);
        System.out.println(answer);
    }

    static int dfs(int n, int r) {
        if (arr[n][r] != 0) return arr[n][r];
        if (n == r || r == 0) return 1;
        return arr[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
    }

}