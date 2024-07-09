package main.java.inflearn.Sorting_and_Searching;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 5 9
 * 1 2 3 2 6 2 3 5 7
 */
public class Main0604 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(in.nextInt());
        }
        for (int i = n; i < m; i++) {
            int tmp = in.nextInt();
            if (!queue.remove(tmp)) {
                queue.poll();
            }
            queue.offer(tmp);
        }
    }

}