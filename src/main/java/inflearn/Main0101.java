package main.java.inflearn;

import java.util.Scanner;

public class Main0101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char chr = in.next().charAt(0);
        chr = Character.toUpperCase(chr);
        int answer = 0;
        for (char c : str.toUpperCase().toCharArray()) {
            if (c == chr) answer++;
        }
        System.out.println(answer);
        return;
    }
}