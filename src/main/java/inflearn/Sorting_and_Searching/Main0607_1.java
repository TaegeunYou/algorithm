package main.java.inflearn.Sorting_and_Searching;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5
 * 2 7
 * 1 3
 * 1 2
 * 2 5
 * 3 6
 */
public class Main0607_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Point[] arr = new Point[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Point(in.nextInt(), in.nextInt());
        }
        Arrays.sort(arr);
        for (Point point : arr) {
            System.out.println(point.x + " " + point.y);
        }
        System.out.println();
    }
    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(@NotNull Point point) {
            int result;
            if (this.x == point.x) {
                result = this.y - point.y;
            } else {
                result = this.x - point.x;
            }
            return result;
        }
    }

}