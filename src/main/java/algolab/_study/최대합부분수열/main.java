package main.java.algolab._study.최대합부분수열;

public class main {
    public static void main(String[] args) {
        int[] arr = {4, -6, 0, 2, 3, -4, 1, 3, 0, -9, 4, 1, -3, 2};
        int maxSum = Integer.MIN_VALUE;
        int maxStartIdx = -1;
        int maxEndIdx = -1;
        int tmpStartIdx = 0;
        int tmpSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (tmpStartIdx == i && arr[i] == 0) {
                tmpStartIdx = i + 1;
                continue;
            }
            tmpSum += arr[i];
            if (tmpSum < 0) {
                tmpStartIdx = i + 1;
                tmpSum = 0;
                continue;
            }
            if (tmpSum > maxSum) {
                maxSum = tmpSum;
                maxStartIdx = tmpStartIdx;
                maxEndIdx = i;
            }
        }
        System.out.println(maxSum + " " + maxStartIdx + " " + maxEndIdx);
    }
}

