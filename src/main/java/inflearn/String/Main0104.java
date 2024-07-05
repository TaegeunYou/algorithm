package main.java.inflearn.String;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main0104 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String str = in.next();
            StringBuilder sb = new StringBuilder();
            for (int j = str.length() - 1; j >= 0; j--) {
                sb.append(str.charAt(j));
            }
            System.out.println(sb);
        }
    }
}