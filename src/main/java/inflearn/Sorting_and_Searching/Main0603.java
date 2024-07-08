package main.java.inflearn.Sorting_and_Searching;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 6
 * 11 7 5 6 10 9
 */
public class Main0603 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i) > list.get(j)) {
                    list.add(j + 1, list.remove(i));
                    break;
                } else if (j == 0) {
                    list.addFirst(list.remove(i));
                }
            }
        }
        System.out.println(list);
    }

}