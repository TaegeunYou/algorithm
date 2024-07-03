package main.java.inflearn;

import java.util.Scanner;

public class Main0102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        StringBuilder answer = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                answer.append(Character.toLowerCase(c));
            } else {
                answer.append(Character.toUpperCase(c));
            }
        }
        System.out.println(answer);
    }
}