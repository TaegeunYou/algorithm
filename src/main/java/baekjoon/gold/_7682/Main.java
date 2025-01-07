package main.java.baekjoon.gold._7682;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int[][] wins = {
        {1,2,3},
        {4,5,6},
        {7,8,9},
        {1,4,7},
        {2,5,8},
        {3,6,9},
        {1,5,9},
        {3,5,7}
    };

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }
            boolean result = check(str);
            if (result) {
                sb.append("valid").append("\n");
                continue;
            }
            sb.append("invalid").append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private boolean check(String str) {
        char[] arr = str.toCharArray();
        int countX = 0;
        int countO = 0;
        for (char c : arr) {
            if (c == 'X') {
                countX++;
                continue;
            }
            if (c == 'O') {
                countO++;
            }
        }
        if (checkWin(arr, 'X', countX, countO)) {
            return true;
        }
        if (checkWin(arr, 'O', countX, countO)) {
            return true;
        }
        if (checkDraw(arr, countX, countO)) {
            return true;
        }
        return false;
    }

    private boolean checkDraw(char[] arr, int countX, int countO) {
        if (countX != 5 || countO != 4) {
            return false;
        }
        for (int[] finish : wins) {
            char a1 = arr[finish[0] - 1];
            char a2 = arr[finish[1] - 1];
            char a3 = arr[finish[2] - 1];
            if (a1 == 'X' && a2 == 'X' && a3 == 'X') {
                return false;
            }
            if (a1 == 'O' && a2 == 'O' && a3 == 'O') {
                return false;
            }
        }
        return true;
    }

    private boolean checkWin(char[] arr, char horse, int countX, int countO) {
        for (int i = 0; i < arr.length; i++) {
            char tmp = arr[i];
            arr[i] = '.';
            boolean flag = true;
            for (int[] finish : wins) {
                char a1 = arr[finish[0] - 1];
                char a2 = arr[finish[1] - 1];
                char a3 = arr[finish[2] - 1];
                if (a1 == 'X' && a2 == 'X' && a3 == 'X') {
                    flag = false;
                    break;
                }
                if (a1 == 'O' && a2 == 'O' && a3 == 'O') {
                    flag = false;
                    break;
                }
            }
            arr[i] = tmp;
            if (flag) {
                for (int[] finish : wins) {
                    char a1 = arr[finish[0] - 1];
                    char a2 = arr[finish[1] - 1];
                    char a3 = arr[finish[2] - 1];
                    if (a1 == horse && a2 == horse && a3 == horse) {
                        if (horse == 'X' && countX == countO + 1) {
                            return true;
                        }
                        if (horse == 'O' && countO == countX) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
