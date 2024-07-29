package main.java.inflearn.DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5 20
 * 10 5
 * 25 12
 * 15 8
 * 6 3
 * 7 4
 */
public class Main1006 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Question[] arr = new Question[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Question(in.nextInt(), in.nextInt());
        }
        int[] dy = new int[m + 1];
        Arrays.fill(dy, 0);
        for (Question question : arr) {
            for (int i = m; i >= question.time; i--) {
                dy[i] = Math.max(dy[i], dy[i - question.time] + question.score);
            }
        }
        System.out.println(dy[m]);
    }

    static class Question {
        int score;
        int time;

        public Question(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

}