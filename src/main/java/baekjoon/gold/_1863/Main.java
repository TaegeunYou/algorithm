package main.java.baekjoon.gold._1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[i][0] = x;
            board[i][1] = y;
        }
        int result = execute(board);
        System.out.println(result);
    }

    private int execute(int[][] board) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for (int[] arr : board) {
            int tmp = arr[1];
            boolean flag = true;
            while (!stack.isEmpty() && stack.peekLast() >= tmp) {
                if (stack.peekLast() == tmp) {
                    flag = false;
                }
                stack.pollLast();
            }
            if (tmp == 0) {
                continue;
            }
            if (flag) {
                result++;
            }
            stack.offerLast(tmp);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
