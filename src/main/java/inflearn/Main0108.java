package main.java.inflearn;

import java.util.Scanner;

public class Main0108 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String tmp = str.toUpperCase().replaceAll("[^A-Z]", "");
        System.out.println(new StringBuilder(tmp).reverse().toString().equals(tmp) ? "YES" : "NO");
    }
}