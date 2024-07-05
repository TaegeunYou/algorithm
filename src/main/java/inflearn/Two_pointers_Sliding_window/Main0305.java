package main.java.inflearn.Two_pointers_Sliding_window;

import java.util.Scanner;

/**
 * 15
 */
public class Main0305 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int answer = 0;
        int lt = 1;
        int rt = 2;
        int sum = 3;
        while (rt <= n/2+1) {
            while (sum > n) {
                sum -= lt++;
            }
            while (sum < n) {
                sum += ++rt;
            }
            if (sum == n) {
                System.out.println("rt: " + (rt) + " lt: " + (lt) + " sum: " + sum);
                answer++;
                sum += (++rt - lt++);
            }
        }
        System.out.println(answer);
    }

}