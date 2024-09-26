package main.java.algolab.스트링순열;

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
            String str = st.nextToken();
            int result = recursive(str, 0, str.length() - 1);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        br.close();
        System.out.println(sb);
    }

    private int recursive(String str, int begin, int end) {
        int range = end - begin + 1;
        int total = 0;
        if (range == 1) return calculateWeight(str) > 0 ? 1 : 0;
        for (int i = 0; i < range; i++) {
            String result = move(str, begin + i, begin);
            total += recursive(result, begin + 1, end);
        }
        return total;
    }

    private String move(String str, int beforeIdx, int afterIdx) {
        char tmp = str.charAt(beforeIdx);

        StringBuilder sb = new StringBuilder(str);
        sb.insert(afterIdx, tmp);
        sb.deleteCharAt(beforeIdx + 1);

        return sb.toString();
    }

    private int calculateWeight(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int tmp = str.charAt(i) - 'a';
            if (i % 2 == 0) result += tmp;
            else result -= tmp;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }

}