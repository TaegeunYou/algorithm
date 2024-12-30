package main.java.baekjoon.bronze._5073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            String result = execute(a, b, c);
            System.out.println(result);
        }
    }

    private String execute(int a, int b, int c) {
        if (a == b && b == c) {
            return "Equilateral";
        }
        List<Integer> list = Stream.of(a, b, c).sorted().collect(Collectors.toList());
        if (list.get(0) + list.get(1) <= list.get(2)) {
            return "Invalid";
        }
        if (a == b || b == c || c == a) {
            return "Isosceles";
        }
        return "Scalene";
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
