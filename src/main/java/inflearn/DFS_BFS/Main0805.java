package main.java.inflearn.DFS_BFS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 3
 * 1 2 5
 * 15
 */
public class Main0805 {

    static int n;
    static int m;
    static Integer[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        m = in.nextInt();
        dfs(0, 0);
        System.out.println(answer);

    }

    static void dfs(int sum, int count) {
        if (sum > m || count >= answer) return;
        if (sum == m) {
            answer = count;
            return;
        }
        for (int i : arr) {
            dfs(sum + i, count + 1);
        }
    }

}