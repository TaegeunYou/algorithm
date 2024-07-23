package main.java.inflearn.DFS_BFS;

import java.util.Scanner;

/**
 * 4 2
 */
class Main0809 {

    static int n, m;
    static int[] arr;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[m];
        dfs(0, 1);
    }

    static void dfs(int L, int s) {
        if (L == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = s; i <= n; i++) {
            arr[L] = i;
            dfs(L + 1, i + 1);
        }
    }

}