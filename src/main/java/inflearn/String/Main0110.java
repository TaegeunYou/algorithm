package main.java.inflearn.String;

import java.util.ArrayList;
import java.util.Scanner;

public class Main0110 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        String[] parts = str.split(" ");
//        String s = parts[0];
//        char t = parts[1].charAt(0);
//        ArrayList<Integer> idxList = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == t) {
//                idxList.add(i);
//            }
//        }
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            int tmp = i;
//            list.add(Integer.toString(idxList.stream().mapToInt(it -> Math.abs(it-tmp)).min().getAsInt()));
//        }
//        String answer = String.join(" ", list);
//        System.out.println(answer);
        /**
         * 왼쪽에 있는 target과의 거리 먼저 계산 후 오른쪽에 있는 target과의 거리 계산하는 방식
         * for문 2번이면 끝남
         */
        String s = in.next();
        char t = in.next().charAt(0);
        int pos = 1000;
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                pos = 0;
            } else {
                pos++;
            }
            arr[i] = pos;
        }
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                pos = 0;
            } else {
                pos++;
            }
            if (arr[i] > pos) {
                arr[i] = pos;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}