package main.java.algolab._study.Total;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class main {

    private void solution() {
//        int[] arr = {3, 5, 4, 2, 1, 7};
        // 3 1 4 2 5 7
        // 3 1 2 4 5 7
        int[] arr = {0, 10, 1, 3, 5, 6, 9, 11, 4, 3};
//        int[] arr = {0, 1, 3, 5, 6, 9, 2};
//        int[] arr = {5, -7, 2, 3, -4, 5, 2, -7, 8, -7};
//        System.out.println(result);
//        System.out.println(Arrays.toString(arr));

//        int[] ints = mergeSortPartition(arr, 0, arr.length - 1);

        heapsort(arr);
//        System.out.println(Arrays.toString(col));
    }

    private void heapsort(int[] arr) {
        makeMaxHeap(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            int max = popMax(arr, arr.length - 1 - i);
            sb.insert(0, max + " ");
        }
        System.out.println(sb);
    }

    private int popMax(int[] arr, int idx) {
        int max = arr[1];
        arr[1] = arr[idx];
        arr[idx] = 0;
        fixHeap(arr, 1);
        return max;
        //[0, 3, 1, 3, 5, 6, 9, 11, 4, 0]
    }

    private void makeMaxHeap(int[] arr) {
        for (int i = arr.length / 2 + 1; i >= 1; i--) {
            fixHeap(arr, i);
        }
    }

    private void fixHeap(int[] arr, int seq) {
        int tmpLevel = log2(seq);
        int leafLevel = log2(arr.length - 1);
        while (tmpLevel < leafLevel) {
            int leftIdx = seq * 2;
            int rightIdx = seq * 2 + 1;
            int left = leftIdx < arr.length ? arr[leftIdx] : Integer.MIN_VALUE;
            int right = rightIdx < arr.length ? arr[rightIdx] : Integer.MIN_VALUE;
            boolean flag = false;
            if (left >= right) {
                if (arr[seq] < left) {
                    swap(arr, seq, leftIdx);
                    seq = leftIdx;
                    flag = true;
                }
            } else {
                if (arr[seq] < right) {
                    swap(arr, seq, rightIdx);
                    seq = rightIdx;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
            tmpLevel++;
        }
    }

    private int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    /**
     *
     * @param row 이전에 검사한 row이고 row + 1이 현재 함수에서 놓을 위치
     * @param col
     */
    private void nQueen(int row, int[] col) {
        if (nQueenIsPromising(row, col)) {
            if (row == 3) {
                System.out.println(Arrays.toString(col));
                return;
            }
            for (int i = 0; i < col.length; i++) {
                col[row + 1] = i;
                nQueen(row + 1, col);
            }
        }
    }

    private boolean nQueenIsPromising(int row, int[] col) {
        for (int i = 0; i < row; i++) {
            if (col[i] == col[row] || (Math.abs(row - i) / Math.abs(col[row] - col[i])) == 1) {
                return false;
            }
        }
        return true;
    }

    private void quickSortLomuto(int[] arr, int lt, int rt) {
        if (lt >= rt) {
            return;
        }
        int pivot = arr[lt];
        int j = lt;
        for (int i = lt + 1; i <= rt; i++) {
            if (arr[i] <= pivot) {
                j++;
                System.out.println(i + " " + j);

                swap(arr, i, j);
            }
        }

        int pivotIdx = j;
        swap(arr, lt, pivotIdx);
        System.out.println(lt + " " + pivotIdx);
        System.out.println();
        quickSortLomuto(arr, lt, pivotIdx - 1);
        quickSortLomuto(arr, pivotIdx + 1, rt);
    }

    private void quickSortHoare(int[] arr, int lt, int rt) {
        if (lt >= rt) {
            return;
        }
        int pivot = arr[lt];
        int i = lt - 1;
        int j = rt + 1;

        while (true) {
            while (arr[++i] < pivot) {
            }
            while (arr[--j] > pivot) {
            }
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            } else {
                break;
            }
        }

        int pivotIdx = j;
        quickSortHoare(arr, lt, pivotIdx);
        quickSortHoare(arr, pivotIdx + 1, rt);
    }

    private int maxSeqSum(int[] arr, int lt, int rt) {
        if (lt == rt) {
            return arr[lt];
        }
        int mid = (lt + rt) / 2;
        int left = maxSeqSum(arr, lt, mid);
        int right = maxSeqSum(arr, mid + 1, rt);
        int containMid = getMaxSeqSumMid(arr, mid);
        return Stream.of(left, right, containMid).max(Comparator.naturalOrder()).get();
    }

    private int getMaxSeqSumMid(int[] arr, int mid) {
        int leftSum = 0;
        int leftSumMax = 0;
        for (int i = mid; i >= 0; i--) {
            leftSum += arr[i];
            if (leftSum < 0) {
                break;
            } else {
                leftSumMax = Math.max(leftSumMax, leftSum);
            }
        }

        int rightSum = 0;
        int rightSumMax = 0;
        for (int i = mid + 1; i < arr.length; i++) {
            rightSum += arr[i];
            if (rightSum < 0) {
                break;
            } else {
                rightSumMax = Math.max(rightSumMax, rightSum);
            }
        }

        return leftSumMax + rightSumMax;
    }

    private void mergeSortIter(int[] arr) {
        int size = 1;
        while (size < arr.length) {
            for (int i = 0; i < arr.length; i += size * 2) {
                int lt = i;
                int mid  = lt + size - 1;
                if (mid >= arr.length - 1) break;
                int rt = Math.min(i + size * 2 - 1, arr.length - 1);
                mergeSortIterMerge(arr, lt, mid, rt);
            }
            size *= 2;
        }
    }

    private void mergeSortIterMerge(int[] arr, int lt, int mid, int rt) {
        int[] copyArray = Arrays.copyOf(arr, arr.length);
        int leftIdx = lt;
        int rightIdx = mid + 1;
        int idx = lt;
        while (leftIdx <= mid && rightIdx <= rt) {
            if (copyArray[leftIdx] <= copyArray[rightIdx]) {
                arr[idx++] = copyArray[leftIdx++];
            } else {
                arr[idx++] = copyArray[rightIdx++];
            }
        }
        while (leftIdx <= mid) {
            arr[idx++] = copyArray[leftIdx++];
        }
        while (rightIdx <= rt) {
            arr[idx++] = copyArray[rightIdx++];
        }
    }

    private int[] mergeSortPartition(int[] arr, int lt, int rt) {
        if (lt == rt) {
            return new int[]{ arr[lt] };
        }
        int mid = (lt + rt) / 2;

        int[] left = mergeSortPartition(arr, lt, mid);
        int[] right = mergeSortPartition(arr, mid + 1, rt);

        return mergeSortMerge(left, right);
    }

    private int[] mergeSortMerge(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < arr1.length && idx2 < arr2.length) {
            if (arr1[idx1] <= arr2[idx2]) {
                arr[idx++] = arr1[idx1++];
            } else if (arr1[idx1] > arr2[idx2]) {
                arr[idx++] = arr2[idx2++];
            }
        }
        while (idx1 < arr1.length) {
            arr[idx++] = arr1[idx1++];
        }
        while (idx2 < arr2.length) {
            arr[idx++] = arr2[idx2++];
        }

        return arr;
    }

    private int findPeakValue(int[] arr, int lt, int rt) {
        int midIdx = (lt + rt) / 2;
        int midValue = arr[midIdx];
        int leftValue = midIdx - 1 >= 0 ? arr[midIdx - 1] : Integer.MIN_VALUE;
        int rightValue = midIdx + 1 < arr.length ? arr[midIdx + 1] : Integer.MAX_VALUE;
        if (midValue > leftValue && midValue > rightValue) {
            return midIdx;
        }
        if (midValue > leftValue && midValue < rightValue) {
            return findPeakValue(arr, midIdx + 1, rt);
        } else {
            return findPeakValue(arr, lt, midIdx - 1);
        }
    }

    private int binarySearch(int[] arr, int lt, int rt, int target) {
        int mid = (lt + rt) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (target > arr[mid]) {
            return binarySearch(arr, mid + 1, rt, target);
        } else {
            return binarySearch(arr, lt, mid, target);
        }
    }

    private int findingMax(int[] arr, int lt, int rt) {
        if (lt == rt) {
            return arr[lt];
        }

        int mid = (lt + rt) / 2;

        int leftMax = findingMax(arr, lt, mid);
        int rightMax = findingMax(arr, mid + 1, rt);
        return Math.max(leftMax, rightMax);
    }

    private void trominoSolution() {
        int[][] board = new int[8][8];
        board[6][2] = -1;
        tromino(board, 8, 0, 0);
        for (int[] arrs : board) {
            for (int i : arrs) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    int trominoNum = 0;

    private void tromino(int[][] board, int n, int x, int y) {
        trominoNum++;
        int size = n / 2;

        if (check(board, x, y, size)) {
            board[x + size - 1][y + size - 1] = trominoNum;
        }
        if (check(board, x + size, y, size)) {
            board[x + size][y + size - 1] = trominoNum;
        }
        if (check(board, x, y + size, size)) {
            board[x + size - 1][y + size] = trominoNum;
        }
        if (check(board, x + size, y + size, size)) {
            board[x + size][y + size] = trominoNum;
        }

        if (n == 2) return;

        tromino(board, size, x, y);
        tromino(board, size, x + size, y);
        tromino(board, size, x, y + size);
        tromino(board, size, x + size, y + size);
    }

    private boolean check(int[][] board, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != 0) return false;
            }
        }
        return true;
    }

    private void knightTourSolution() {
        int[][] board = new int[8][8];
        board[0][7] = 1;
        knightTour(board, 0, 7, 2);
        for (int[] row : board) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private boolean knightTour(int[][] board, int x, int y, int n) {
        if (n == board.length * board[0].length + 1) {
            return true;
        }
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 0) {
                board[nx][ny] = n;
                if (knightTour(board, nx, ny, n + 1)) {
                    return true;
                }
                board[nx][ny] = 0;
            }
        }
        return false;
    }

    private void hanoiSolution(int n) {
        HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            map.put(i, new ArrayDeque<>());
        }
        for (int i = n; i >= 1; i--) {
            map.get(1).offerLast(i);
        }
        hanoi(map, n, 1, 2, 3);
        for (int i : map.get(3)) {
            System.out.print(i + " ");
        }
    }

    private void hanoi(HashMap<Integer, ArrayDeque<Integer>> map, int n, int start, int mid, int end) {
        if (n == 1) {   //6일때 6을 옮기니깐 1일때 1을 옮겨서 base case n == 1 인 경우에 확인한다.
            move(map, start, end);
            return;
        }
        hanoi(map, n - 1, start, end, mid);
        move(map, start, end);
        hanoi(map, n - 1, mid, start, end);
    }

    private void move(HashMap<Integer, ArrayDeque<Integer>> map, int start, int end) {
        ArrayDeque<Integer> queue = map.get(start);
        Integer i = queue.pollLast();
        map.get(end).offerLast(i);
    }

    private void permutation3(char[] arr, int begin, int end) {
        int range = end - begin + 1;
        if (range == 0) {
            System.out.println(new String(arr));
        }
        for (int i = 0; i < range; i++) {
            String s = insertChar(arr, begin, begin + i);
            permutation2(s.toCharArray(), begin + 1, end);
        }
    }

    private String insertChar(char[] arr, int i, int j) {
        StringBuilder sb = new StringBuilder(String.valueOf(arr));
        sb.insert(i, arr[j]);
        sb.deleteCharAt(j + 1);
        return sb.toString();
    }

    private void permutation2(char[] arr, int begin, int end) {
        int range = end - begin + 1;
        if (range == 0) {
            System.out.println(new String(arr));
        }
        for (int i = 0; i < range; i++) {
            swapIdx(arr, begin, begin + i);
            permutation2(arr, begin + 1, end);
            swapIdx(arr, begin, begin + i);
        }
    }

    private void permutation(char[] arr, int n) {
        if (n == arr.length) {
            System.out.println(new String(arr));
        }
        for (int i = n; i < arr.length; i++) {
            swapIdx(arr, n, i);
            permutation(arr, n + 1);
            swapIdx(arr, n, i);
        }
    }

    private void swapIdx(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void getNextPermutation(String str) {
        int a = 0;
        for (int i = str.length() - 2; i >= 1; i--) {
            if (str.charAt(i) < str.charAt(i + 1)) {
                a = i;
                break;
            }
        }

        int min = Integer.MAX_VALUE;
        int b = -1;
        for (int i = a + 1; i < str.length(); i++) {
            if (str.charAt(i) > str.charAt(a) && str.charAt(i) < min) {
                min = str.charAt(i);
                b = i;
            }
        }

        char[] arr = swap(str, a, b);
        char[] reverse = reverse(arr, a + 1);
        System.out.println(new String(reverse));
    }

    private char[] reverse(char[] arr, int startIdx) {
        String s =
            new String(arr).substring(0, startIdx) + new StringBuilder(new String(arr).substring(startIdx)).reverse();
        return s.toCharArray();
    }

    private char[] swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
        return charArray;
    }

    private void baseConversion(int x, int n) {
        if (x >= n) {
            baseConversion(x / n, n);
        }
        System.out.print(x % n);
    }

    private boolean palindrome(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private int fastPower(int x, int n) {
        if (n == 1) {
            return x;
        }
        if (n % 2 == 1) {
            return x * fastPower(x, n - 1);
        } else {
            int half = fastPower(x, n / 2);
            return half * half;
        }
    }

    private int power(int x, int n) {
        if (n == 1) {
            return x;
        }
        return x * power(x, n - 1);
    }

    private void reversingArray(int[] arr, int n) {
        if (n == arr.length / 2) {
            return;
        }
        swap(arr, n, arr.length - 1 - n);
        reversingArray(arr, n + 1);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int linearSum(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return arr[n - 1] + linearSum(arr, n - 1);
    }

    private int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    private int factorial(int n) {
        if (n <= 1) return n;
        return n * factorial(n - 1);
    }

    private void maxSeqSum3(int[] arr) {
        int max = Integer.MIN_VALUE;
        int maxStartIdx = 0;
        int maxEndIdx = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                maxStartIdx = i + 1;
                sum = 0;
            } else if (sum > max) {
                max = sum;
                maxEndIdx = i;
            }
        }
        System.out.println(max + " " + maxStartIdx + " " + maxEndIdx);
    }

    private void maxSeqSum2(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }

    private void maxSeqSum1(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }

    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                arr[minIdx] = arr[i];
                arr[i] = min;
            }
        }
    }

    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    private void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i - 1;
            int value = arr[i];
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }

}
