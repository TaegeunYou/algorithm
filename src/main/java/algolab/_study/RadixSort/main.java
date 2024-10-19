package main.java.algolab._study.RadixSort;

import java.util.ArrayList;

public class main {

    private void solution() {
        int[] arr = {123, 322, 513, 126, 943, 223, 231};
        int length = 3;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<>());
        }
        for (int i : arr) {
            int arrIdx = Integer.toString(i).charAt(2) - '0';
            list.get(arrIdx).add(i);
        }
        recursion(1, list, length);
    }

    private void recursion(int idx, ArrayList<ArrayList<Integer>> list, int length) {
        if (idx < 0) {
            for (ArrayList<Integer> nums : list) {
                for (int num : nums) {
                    System.out.print(num + " ");
                }
            }
            return;
        }
        ArrayList<ArrayList<Integer>> tmpList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tmpList.add(new ArrayList<>());
        }
        for (ArrayList<Integer> nums : list) {
            for (int num : nums) {
                int arrIdx = Integer.toString(num).charAt(idx) - '0';
                tmpList.get(arrIdx).add(num);
            }
        }
        recursion(idx - 1, tmpList, length);
    }

    public static void main(String[] args) {
        new main().solution();
    }
}
