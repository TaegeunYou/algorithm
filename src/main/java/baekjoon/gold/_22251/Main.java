package main.java.baekjoon.gold._22251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "1110111");
        map.put(1, "0010010");
        map.put(2, "1011101");
        map.put(3, "1011011");
        map.put(4, "0111010");
        map.put(5, "1101011");
        map.put(6, "1101111");
        map.put(7, "1010010");
        map.put(8, "1111111");
        map.put(9, "1111011");
        int result = execute(n, k, p, x, map);
        System.out.println(result);
    }

    private int execute(int n, int k, int p, int x, Map<Integer, String> map) {
        List<String> tmp = exchange(k, x, map);
        int result = 0;
        for (int i = 1; i <= n; i++) {
            List<String> floor = exchange(k, i, map);
            int sum = 0;
            for (int j = 0; j < tmp.size(); j++) {
                String before = tmp.get(j);
                String after = floor.get(j);
                for (int w = 0; w < before.length(); w++) {
                    if (before.charAt(w) != after.charAt(w)) {
                        sum++;
                    }
                }
            }
            if (sum > 0 && sum <= p) {
                result++;
            }
        }
        return result;
    }

    private List<String> exchange(int k, int num, Map<Integer, String> map) {
        String str = "0".repeat(k - Integer.toString(num).length()) + num;
        List<String> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(map.get(c - '0'));
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
