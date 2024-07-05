package main.java.inflearn.String;

import java.util.Scanner;

/**
 * KKHSSSSSSSE
 */
public class Main0111_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int cnt = 1;
        char tmp = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (tmp == c) {
                cnt++;
            } else {
                sb.append(tmp);
                sb.append(cnt);
                cnt = 1;
                tmp = c;
            }
        }
        String answer = (sb.substring(2) + tmp + cnt).replaceAll("1", "");
        System.out.println(answer);
    }


}