package main.java.algolab._study.recursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        new main().solution();
    }

    private void solution() {

    }

    private void knightTourSolution() {
        int[][] arr = new int[6][5];
        arr[0][0] = 1;
        knightTour(0, 0, 6, 5, new int[6][5], 1);
    }

    private void knightTour(int x, int y, int n, int m, int[][] board, int num) {
        if (num == n * m) {
            return;
        }
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                board[nx][ny] = num + 1;
                knightTour(nx, ny, n, m, board, num + 1);
                board[nx][ny] = 0;
            }
        }
    }

    private void hanoiSolution() {
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            map.put(i, new LinkedList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < 5; i++) {
            queue.offer(i);
        }
        map.put(1, queue);
        hanoi(map, 1, 2, 3, 4);
    }

    private void hanoi(HashMap<Integer, Queue<Integer>> map, int start, int mid, int end, int n) {
        if (n == 1) {
            move(map, start, end);
            return;
        }
        hanoi(map, start, end, mid, n - 1);
        //move
        move(map, start, end);
        hanoi(map, mid, start, end, n - 1);
    }

    private void move(HashMap<Integer, Queue<Integer>> map, int i, int j) {
        Queue<Integer> integers = map.get(i);
        Integer poll = integers.poll();
        map.get(j).offer(poll);
        System.out.println("move " + poll + ", " + i + " to " + j);
    }

    private void printPermutationByInsert(char[] arr, int i) {
        if (i == arr.length) {
            String s = new String(arr);
            System.out.println("s = " + s);
        }
        for (int j = i; j < arr.length; j++) {
            String str = insert(arr, i, j);
            printPermutationByInsert(str.toCharArray(), i + 1);
        }
    }

    private String insert(char[] arr, int i, int j) {
        //기존 j를 지운다.
        StringBuilder sb = new StringBuilder(new String(arr));
        char c = sb.charAt(j);
        sb.deleteCharAt(j);
        //i번째 위치에 j를 넣는다.
        sb.insert(i, c);
        return sb.toString();
    }

    private void printPermutationBySwap(char[] arr, int i) {
        if (i == arr.length) {
            String s = new String(arr);
            System.out.println("s = " + s);
        }
        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            printPermutationBySwap(arr, i + 1);
            swap(arr, i, j);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private String getNextPermutation(String str) {
        //find first decrease char
        int rt;
        for (rt = str.length() - 2; rt >= 0; rt--) {
            if (str.charAt(rt) < str.charAt(rt + 1)) {
                break;
            }
        }
        //find min after rt
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = rt + 1; i < str.length() - 1; i++) {
            if (min > str.charAt(i) && str.charAt(i) > str.charAt(rt)) {
                min = str.charAt(i);
                minIdx = i;
            }
        }
        //swap
        char[] arr = str.toCharArray();
        char tmp = arr[rt];
        arr[rt] = arr[minIdx];
        arr[minIdx] = tmp;
        //reverse
        reversingArray(arr, rt + 1, arr.length - 1);
        String s = new String(arr);
        return s;
    }

    private void reversingArray(char[] arr, int lt, int rt) {
        if (lt >= rt) {
            return;
        }
        char tmp = arr[lt];
        arr[lt] = arr[rt];
        arr[rt] = tmp;
        reversingArray(arr, lt + 1, rt - 1);
    }

    private boolean checkPalindrome(String str) {
        int lt = 0;
        int rt = str.length() - 1;
        while (lt < rt) {
            if (str.charAt(lt++) != str.charAt(rt--)) {
                return false;
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int fastPower(int x, int n) {
        if (n == 1) return x;
        if (n % 2 == 1) {
            return fastPower(x, 1) * fastPower(x, n / 2) * fastPower(x, n / 2);
        }
        return fastPower(x, n / 2) * fastPower(x, n / 2);
    }

    private int power(int x, int n) {
        if (n == 1) return x;
        return x * power(x, n - 1);
    }

    private void reversingArray(int[] arr, int lt, int rt) {
        if (lt >= rt) {
            return;
        }
        int tmp = arr[lt];
        arr[lt] = arr[rt];
        arr[rt] = tmp;
        reversingArray(arr, lt + 1, rt - 1);
    }

    private int sum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sum(num - 1);
    }

    private int fibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    private static int factorial(int num) {
        if (num == 1) return num;
        return num * factorial(num - 1);
    }
}
