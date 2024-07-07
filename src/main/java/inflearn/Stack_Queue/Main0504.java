package main.java.inflearn.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 352+*9-
 */
public class Main0504 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int tmp1 = stack.pop();
                int tmp2 = stack.pop();
                if (c == '+') {
                    stack.push(tmp1 + tmp2);
                } else if (c == '-') {
                    stack.push(tmp2 - tmp1);
                } else if (c == '*') {
                    stack.push(tmp1 * tmp2);
                } else if (c == '/') {
                    stack.push(tmp2 / tmp1);
                }
            }
        }
        System.out.println(stack.peek());
    }

}