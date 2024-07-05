package main.java.inflearn.Two_pointers_Sliding_window;

import java.util.Scanner;

/**
 * 15
 */
public class Main0305_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int lt = 1, sum = 0, answer = 0;
        for (int rt = 1; rt <= n/2+1; rt++) {    //rt 늘리기
            sum += rt;
            while (sum > n) {   //lt 늘리기
                sum -= lt++;
            }
            if (sum == n) {
                System.out.println("rt: " + (rt) + " lt: " + (lt) + " sum: " + sum);
                answer++;
            }
        }
        System.out.println(answer);
    }

}