package main.java.baekjoon.silver._4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }
            boolean result = avail(str);
            if (result) {
                System.out.println("<" + str + "> is acceptable.");
                continue;
            }
            System.out.println("<" + str + "> is not acceptable.");
        }
    }

    private boolean avail(String str) {
        char[] arr = str.toCharArray();
        if (!check1(arr)) {
            return false;
        }
        if (!check2(arr)) {
            return false;
        }
        if (!check3(arr)) {
            return false;
        }
        return true;
    }

    private boolean check1(char[] arr) {
        for (char c : arr) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
        }
        return false;
    }

    private boolean check2(char[] arr) {
        List<Character> characters = Arrays.asList('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < arr.length - 2; i++) {
            if (characters.contains(arr[i]) && characters.contains(arr[i + 1]) && characters.contains(arr[i + 2])){
                return false;
            }
            if (!characters.contains(arr[i]) && !characters.contains(arr[i + 1]) && !characters.contains(arr[i + 2])){
                return false;
            }
        }
        return true;
    }

    private boolean check3(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 'e' || arr[i] == 'o') {
                continue;
            }
            if (arr[i] == arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
