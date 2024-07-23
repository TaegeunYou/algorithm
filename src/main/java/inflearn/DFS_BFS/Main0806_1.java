package main.java.inflearn.DFS_BFS;

import java.util.Scanner;

/**
 * 3
 * 1 2 5
 * 15
 */
public class Main0806_1 {

    static int n, m;
    static int[] arr, answer, ch;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        answer = new int[m];
        dfs(0);
    }

    static void dfs(int L) {
        if (L == m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                answer[L] = arr[i];
                dfs(L + 1);
                ch[i] = 0;
            }
        }
    }

}