package main.java.inflearn.Recursive_Tree_Graph;

import java.util.Scanner;

/**
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 */
public class Main0712 {

    static int[][] arr;
    static int[] check;
    static int n;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        arr = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            arr[a][b] = 1;
        }
        check = new int[n + 1];
        check[1] = 0;
        dfs(1);
        System.out.println(answer);
    }

    static void dfs(int num) {
        if (num == n) {
            answer++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (arr[num][i] == 1 && check[i] == 0) {
                check[i] = 1;
                dfs(i);
                check[i] = 0;
            }
        }
    }
}