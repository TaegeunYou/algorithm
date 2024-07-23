package main.java.inflearn.DFS_BFS;

import java.util.Scanner;

/**
 * 3 2
 */
public class Main0804 {

    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        dfs(0, "");
    }

    static void dfs(int L, String str) {
        if (L == m) {
            System.out.println(str);
            return;
        }
        for (int i = 1; i <= n; i++) {
            dfs(L + 1, str + i + " ");
        }
    }




}