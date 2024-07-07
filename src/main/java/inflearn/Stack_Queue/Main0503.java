package main.java.inflearn.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 5
 * 0 0 0 0 0
 * 0 0 1 0 3
 * 0 2 5 0 1
 * 4 2 4 4 2
 * 3 5 1 3 1
 * 8
 * 1 5 3 5 1 2 1 4
 */
public class Main0503 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int m = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < m; i++) {
            int tmpCol = in.nextInt() - 1;
            for (int j = 0; j < n; j++) {
                int tmp = arr[j][tmpCol];
                if (tmp != 0) {
                    if (!stack.isEmpty() && stack.peek() == tmp) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(tmp);
                    }
                    arr[j][tmpCol] = 0;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

}