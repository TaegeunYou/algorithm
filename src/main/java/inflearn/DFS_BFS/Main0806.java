package main.java.inflearn.DFS_BFS;

import java.util.*;

/**
 * 3
 * 1 2 5
 * 15
 */
public class Main0806 {

    static int n, m;
    static Integer[] arr;
    static int[] answer;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        answer = new int[m];
        dfs(0, Arrays.asList(arr));
    }

    static void dfs(int L, List<Integer> remain) {
        if (L == m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < remain.size(); i++) {
            answer[L] = remain.get(i);
            ArrayList<Integer> list = new ArrayList<>(remain);
            list.remove(i);
            dfs(L + 1, list);
        }
    }

}