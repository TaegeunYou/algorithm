package main.java.algolab._study.HeapSort;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 5, 6, 9, 2, 1};
        new main().solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void solution(int[] arr) {
        makeMaxHeap(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int poll = deleteHeap(arr, i + 1);
            System.out.println("poll = " + poll);
        }
    }

    private int deleteHeap(int[] arr, int seq) {
        int removeIdx = arr.length - seq;
        int leafLevel = log2(removeIdx - 1);
        int root = arr[1];
        arr[1] = arr[removeIdx];
        arr[removeIdx] = 0;
        fixHeap(arr, 1, leafLevel);
        return root;
    }

    private void makeMaxHeap(int[] arr) {
        int leafLevel = log2(arr.length - 1);
        for (int i = arr.length / 2; i >= 1; i--) {
            fixHeap(arr, i, leafLevel);
        }
    }

    private void fixHeap(int[] arr, int idx, int leafLevel) {
        int level = log2(idx);
        while (level < leafLevel) {
            int tmp = arr[idx];
            int rightChildIdx = idx * 2;
            int leftChildIdx = idx * 2 + 1;
            Pair bigger = findBigger(arr, leftChildIdx, rightChildIdx);
            if (bigger.num != null && tmp < bigger.num) {
                arr[idx] = bigger.num;
                arr[bigger.idx] = tmp;
            }
            level++;
            if (bigger.idx != null) {
                idx = bigger.idx;
            }
        }
    }

    class Pair {
        Integer num;
        Integer idx;

        public Pair(Integer num, Integer idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    private Pair findBigger(int[] arr, int lt, int rt) {
        Integer right = rt < arr.length ? arr[rt] : null;
        Integer left = lt < arr.length ? arr[lt] : null;
        Integer maxNum;
        Integer maxIdx;
        if (right == null && left == null) {
            maxNum = null;
            maxIdx = null;
        } else if (right == null) {
            maxNum = left;
            maxIdx = lt;
        } else if (left == null) {
            maxNum = right;
            maxIdx = rt;
        } else {
            if (left >= right) {
                maxNum = left;
                maxIdx = lt;
            } else {
                maxNum = right;
                maxIdx = rt;
            }
        }
        return new Pair(maxNum, maxIdx);
    }

    private static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}
