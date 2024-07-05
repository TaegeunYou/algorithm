package main.java.inflearn.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 4 3
 * 3 4 1 2
 * 4 3 2 1
 * 3 1 4 2
 */
public class Main0212 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int answer = 0;
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        for (int i = 1; i < n + 1; i++) {     //i 학생
            int[] array = new int[n + 1];     //나보다 등수가 높은 애들은 1로 바꾸기
            for (int j = 1; j < m + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    int tmp = arr[j][k];
                    array[tmp] = 1;
                    if (tmp == i) {
                        break;
                    }
                }
            }
            System.out.println(Arrays.toString(array));
            answer += (int) Arrays.stream(array).filter(it -> it == 0).count();
        }
        answer -= n;
        System.out.println(answer);
    }

}