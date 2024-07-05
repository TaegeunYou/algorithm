package main.java.inflearn.Two_pointers_Sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 5
 * 1 3 9 5 2
 * 5
 * 3 2 5 7 8
 */
public class Main0302 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = in.nextInt();
        }
        Arrays.sort(nArr);
        Arrays.sort(mArr);
        int np = 0, mp = 0;
        ArrayList<Integer> answers = new ArrayList<>();
        while (np < n && mp < m) {
            if (nArr[np] < mArr[mp]) {
                np++;
            } else if (nArr[np] > mArr[mp]) {
                mp++;
            } else {
                answers.add(nArr[np++]);
                mp++;
            }
        }
        System.out.println(answers);
    }

}