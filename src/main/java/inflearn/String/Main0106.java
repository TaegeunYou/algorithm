package main.java.inflearn.String;

import java.util.ArrayList;
import java.util.Scanner;

public class Main0106 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        ArrayList<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!list.contains(c)) {
                list.add(c);
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}