package main.java.algolab._study.DivideAndConquer;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {
        new main().solution();
    }

    private void solution() {
        int[] arr = {1, 3, 5, 6, 9, 2, 1};
        int[] col = new int[8];
        nQueenRecursion(-1, new int[8]);
        String string = Arrays.toString(arr);
//        System.out.println("string = " + string);
    }

    private void nQueenRecursion(int row, int[] col) {
        if (!promising(row, col)) {
            return;
        }
        if (row == col.length - 1) {
            System.out.println(Arrays.toString(col));
            return;
        }
        for (int i = 0; i < col.length; i++) {
            col[row + 1] = i;
            nQueenRecursion(row + 1, col);
        }
    }

    private boolean promising(int row, int[] col) {
        if (row == -1) {
            return true;
        }
        int colValue = col[row];
        for (int i = 0; i < row; i++) {     //row 전까지만 검사하면 됨
            if (colValue == col[i] || Math.abs(row - colValue) == Math.abs(i - col[i])) {   //대각선(기울기)도 검사해야 됨
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
                swap(arr, i, ++j);
            }
        }
        swap(arr, lt, j);

        //hoare 방식과는 다르게 pivot은 가만히 두기
        quickSortLomuto(arr, lt, j - 1);
        quickSortLomuto(arr, j + 1, rt);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void quickSortHoare(int[] arr, int lt, int rt) {
        if (lt == rt) {
            return;
        }
        int pivot = arr[lt];
        int i = lt - 1;
        int j = rt + 1;
        while (i < j) {
            while (arr[++i] < pivot) {
            }
            while (arr[--j] > pivot) {
            }
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        quickSortHoare(arr, lt, j);
        quickSortHoare(arr, j + 1, rt);
    }

    private void mergeSortIter(int[] arr) {
        int size = 1;
        int n = arr.length;
        while (size < n) {
            for (int i = 0; i < arr.length; i += size * 2) {
                int start = i;
                int mid = start + size - 1;
                int end = Math.min(i + 2 * size - 1, n - 1);
                if (mid >= n - 1) {
                    break;
                }
                merge(arr, start, mid, end);
            }
            size *= 2;
        }
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = Arrays.copyOf(arr, arr.length);

        int i = start;
        int j = mid + 1;
        int idx = i;

        while (i <= mid && j <= end) {
            if (tmp[i] <= tmp[j]) {
                arr[idx++] = tmp[i++];
            } else {
                arr[idx++] = tmp[j++];
            }
        }

        while (i <= mid) {
            arr[idx++] = tmp[i++];
        }
        while (j <= end) {
            arr[idx++] = tmp[j++];
        }
    }

    private int[] mergeSort(int[] arr, int lt, int rt) {
        if (lt == rt) {
            return new int[]{arr[lt]};
        }
        int mid = (lt + rt) / 2;
        int size = rt - lt + 1;
        int[] arr1 = mergeSort(arr, lt, mid);
        int[] arr2 = mergeSort(arr, mid + 1, rt);
        return mergeSortConquer(size, arr1, arr2);
    }

    private int[] mergeSortConquer(int n, int[] arr1, int[] arr2) {
        int[] arr = new int[n];
        int arrIdx = 0;
        int arr1Idx = 0;
        int arr2Idx = 0;
        while (true) {
            while (arr1Idx < arr1.length && arr2Idx < arr2.length && arr1[arr1Idx] <= arr2[arr2Idx]) {
                arr[arrIdx++] = arr1[arr1Idx++];
            }
            while (arr1Idx < arr1.length && arr2Idx < arr2.length && arr1[arr1Idx] > arr2[arr2Idx]) {
                arr[arrIdx++] = arr2[arr2Idx++];
            }
            if (arr1Idx >= arr1.length || arr2Idx >= arr2.length) {
                break;
            }
        }
        while (arr1Idx < arr1.length) {
            arr[arrIdx++] = arr1[arr1Idx++];
        }
        while (arr2Idx < arr2.length) {
//            System.out.println("2 " + arr2.length);
            arr[arrIdx++] = arr2[arr2Idx++];
        }
        return arr;
    }

    private int findPeakIdx(int[] arr, int lt, int rt) {
        int midIdx = (lt + rt) / 2;
        int midNum = arr[midIdx];
        int left = midIdx - 1 < 0 ? Integer.MIN_VALUE : arr[midIdx - 1];
        int right = midIdx + 1 >= arr.length ? Integer.MAX_VALUE : arr[midIdx + 1];
        if (midNum > left && midNum > right) {
            return midIdx;
        }
        if (midNum > left && midNum < right) {
            return findPeakIdx(arr, midIdx + 1, rt);
        } else {
            return findPeakIdx(arr, lt, midIdx - 1);
        }
    }

    private int binarySearch(int[] arr, int lt, int rt, int target) {
        int mid = (lt + rt) / 2;
        int tmp = arr[mid];
        if (tmp == target) {
            return mid;
        }
        if (tmp > target) {
            rt = mid - 1;
        } else {
            lt = mid + 1;
        }
        return binarySearch(arr, lt, rt, target);
    }

    private int findingMax(int[] arr, int lt, int rt) {
        if (lt == rt) {
            return arr[lt];
        }
        int mid = (lt + rt) / 2;
        int left = findingMax(arr, lt, mid);
        int right = findingMax(arr, mid + 1, rt);
        return Math.max(left, right);
    }
}
