package main.java.inflearn.String;

import java.util.Scanner;

public class Main0105 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] charArray = str.toCharArray();
        int lt = 0 ;
        int rt = str.length() - 1;
        while (lt < rt) {
            if (Character.isAlphabetic(charArray[lt])) {
                char c = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = c;
            }
            lt++;
            rt--;
        }
        String answer = String.valueOf(charArray);
        System.out.println(answer);
    }
}