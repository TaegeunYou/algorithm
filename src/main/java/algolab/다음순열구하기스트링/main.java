package main.java.algolab.다음순열구하기스트링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            String result = findNext(str);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }

    private String findNext(String str) {
        int i = findI(str);
        if (i == -1) {
            return new StringBuilder(str).reverse().toString();
        }
        int j = findJ(str, i);
        String newStr = swap(str, i, j);
        return reverseAfterIdx(newStr, i);
    }

    private int findI(String str) {
        int num = -1;
        for (int i = str.length() - 2; i >= 0; i--) {
            if (str.charAt(i) < str.charAt(i + 1)) {
                num = i;
                break;
            }
        }
        return num;
    }

    private int findJ(String str, int num) {
        Character min = null;
        int minIdx = 0;
        for (int i = num + 1; i < str.length(); i++) {
            if (str.charAt(i) > str.charAt(num)) {
                if (min == null || min > str.charAt(i)) {
                    min = str.charAt(i);
                    minIdx = i;
                }
            }
        }
        return minIdx;
    }

    private String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return new String(arr);
    }

    private String reverseAfterIdx(String str, int idx) {
        String prefix = str.substring(0, idx + 1);
        StringBuilder sb = new StringBuilder(str.substring(idx + 1));
        sb.reverse();
        return prefix + sb;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}
