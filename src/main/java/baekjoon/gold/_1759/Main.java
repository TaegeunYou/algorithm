package main.java.baekjoon.gold._1759;

import java.io.*;
import java.util.*;

public class Main {

    int l;
    char[] arr;
    List<Character> chars = new ArrayList<>();
    List<Character> aWords = Arrays.asList('a', 'e', 'i', 'o', 'u');
    StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new char[c];
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        recursive(0);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private void recursive(int idx) {
        if (chars.size() == l) {
            if (validate()) {
                for (char c : chars) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }
        if (idx == arr.length) {
            return;
        }
        chars.add(arr[idx]);
        recursive(idx + 1);
        chars.remove(chars.size() - 1);
        recursive(idx + 1);
    }

    private boolean validate() {
        int aWordCount = 0;
        int bWordCount = 0;
        for (Character c : chars) {
            if (aWords.contains(c)) {
                aWordCount++;
            } else {
                bWordCount++;
            }
        }
        return aWordCount >= 1 && bWordCount >= 2;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
