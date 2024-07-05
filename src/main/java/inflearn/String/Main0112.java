package main.java.inflearn.String;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 4
 * #****###**#####**#####**##**
 */
public class Main0112 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int cnt = in.nextInt();
        String str = in.next().replace('#', '1').replace('*', '0');
        for (int i = 0; i < cnt; i++) {
            sb.append(
                (char) Integer.parseInt(str.substring(i * 7, i * 7 + 7), 2)
            );
        }
        System.out.println(sb);
    }

}