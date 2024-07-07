package main.java.inflearn.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 8 3
 */
public class Main0506 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < n + 1; i++) {
            stack.push(i);
        }
        int idx = 0;
        while (stack.size() != 1) {
            idx = (idx + k - 1) % stack.size();
            stack.remove(idx);
        }
        System.out.println(stack.peek());
    }

}