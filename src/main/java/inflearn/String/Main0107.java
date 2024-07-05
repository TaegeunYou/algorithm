package main.java.inflearn.String;

import java.util.Scanner;

public class Main0107 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next().toUpperCase();
        String answer = "YES";
        for (int i = 0; i < str.length()/2; i++) {
            System.out.println("i = " + i);
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                answer = "NO";
                break;
            }
        }
        /*
        String str = in.next();
        String answer = str.equalsIgnoreCase(new StringBuilder(str).reverse().toString()) ? "YES" : "NO";
        */
        System.out.println(answer);
    }
}