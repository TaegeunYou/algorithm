package main.java.inflearn.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 */
public class Main0502_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }
        for (char c : stack) {
            System.out.print(c);
        }
    }

}