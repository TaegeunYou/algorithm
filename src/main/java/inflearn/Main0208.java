package main.java.inflearn;

import java.util.*;

/**
 * 5
 * 87 89 92 100 76
 */
public class Main0208 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            integers.add(in.nextInt());
        }
        List<Integer> list = integers.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        for (int i : integers) {
            System.out.print(list.indexOf(i) + 1 + " ");
        }
    }

}