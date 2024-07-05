package main.java.inflearn.String;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main0109 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int answer = Integer.parseInt(str.replaceAll("[^0-9]", ""));
        /*String newStr = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                newStr += c;
            }
        }
        int answer = Integer.parseInt(newStr);*/
        System.out.println(answer);
    }
}