package main.java.algolab._study.FindPeakValue;

public class main {
    public static void main(String[] args) {
        int[] arr = {12, 15, 20, 25, 32, 35, 40, 45, 31, 26, 12, 9, 7, 3};
        int answer = recursion(arr, 0, arr.length - 1);
        System.out.println("answer = " + answer);
    }

    private static int recursion(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int midLeftNum = mid - 1 >= 0 ? arr[mid - 1] : -1;
        int midRightNum = mid + 1 < arr.length ? arr[mid + 1] : Integer.MAX_VALUE;

        boolean isTarget = arr[mid] >= midLeftNum && arr[mid] >= midRightNum;
        boolean isIncrease = arr[mid] >= midLeftNum && arr[mid]  <= midRightNum;

        if (isTarget) {
            return mid;
        } else if (isIncrease) {
            return recursion(arr, mid + 1, right);
        } else {    //감소
            return recursion(arr, left, mid - 1);
        }
    }
}