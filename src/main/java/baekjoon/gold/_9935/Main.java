package main.java.baekjoon.gold._9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String eStr = br.readLine();
        String result = execute(str, eStr);
        if (result.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(result);
        }
    }

    private String execute(String str, String eStr) {
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
            while (isContain(list, eStr)) {
                for (int i = 0; i < eStr.length(); i++) {
                    list.remove(list.size() - 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean isContain(List<Character> list, String eStr) {
        for (int i = 0; i < eStr.length(); i++) {
            int listIdx = list.size() - eStr.length() + i;
            if (listIdx < 0 || listIdx >= list.size()) {
                return false;
            }
            if (eStr.charAt(i) != list.get(list.size() - eStr.length() + i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
