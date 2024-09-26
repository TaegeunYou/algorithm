package main.java.algolab.스트링뒤집기;

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
            String result = execute(str);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        br.close();
        System.out.println(sb);
    }

    private String execute(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            char tmp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = tmp;
        }
        return new String(charArray);
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }

}