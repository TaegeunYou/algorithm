package main.java.inflearn.DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5
 * 25 3 4
 * 4 4 6
 * 9 2 3
 * 16 2 5
 * 1 5 2
 */
public class Main1004 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Rock[] arr = new Rock[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Rock(in.nextInt(), in.nextInt(), in.nextInt());
        }
        Arrays.sort(arr);
        int[] dy = new int[n];
        dy[0] = arr[0].height;
        int answer = dy[0];
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j].weight > arr[i].weight && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + arr[i].height;
            answer = Math.max(answer, dy[i]);
        }
        System.out.println(answer);
    }

    static class Rock implements Comparable<Rock> {
        int floor;
        int height;
        int weight;

        public Rock(int floor, int height, int weight) {
            this.floor = floor;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Rock o) {
            return o.floor - this.floor;
        }
    }

}