package main.java.inflearn.Stack_Queue;

import java.util.Scanner;

/**
 * (()(()))(()
 */
public class Main0501 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int i = 0;
        String answer = "YES";
        for (char c : n.toCharArray()) {
            if (c == '(') {
                i++;
            } else if (c == ')') {
                i--;
            }
            if (i < 0) {
                answer = "NO";
                break;
            }
        }
        if (i > 0) {
            System.out.println("NO");
        } else {
            System.out.println(answer);
        }
    }

}