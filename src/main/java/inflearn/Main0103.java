package main.java.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Main0103 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int max = -1;
        String answer = null;
        for (String s : str.split(" ")) {
            if (s.length() > max) {
                max = s.length();
                answer = s;
            }
        }
        System.out.println(answer);
    }
}