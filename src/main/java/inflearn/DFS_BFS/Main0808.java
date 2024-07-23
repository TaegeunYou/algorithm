package main.java.inflearn.DFS_BFS;

import java.util.Scanner;

/**
 * 5 3
 */
class Main0808 {

    static boolean flag = false;
    static int n, f;
    static int[] ch, arr;
    static int[][] perArr;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = in.nextInt();
        ch = new int[n + 1];
        arr = new int[n];
        perArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            permutation(n - 1, i);
        }
        dfs(0);
    }

    static void dfs(int L) {
        if (flag) return;
        if (L == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (arr[i] * perArr[n - 1][i]);
            }
            if (sum == f) {
                for (int i : arr) {
                    System.out.print(i + " ");
                }
                flag = true;
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                arr[L] = i;
                dfs(L + 1);
                ch[i] = 0;
            }
        }
    }

    static int permutation(int n, int r) {
        if (perArr[n][r] != 0) return perArr[n][r];
        if (n == r || r == 0) {
            perArr[n][r] = 1;
            return 1;
        }
        return perArr[n][r] = permutation(n - 1, r - 1) + permutation(n - 1, r);
    }

}