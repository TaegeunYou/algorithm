package main.java.baekjoon.bronze._2816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        String result = execute(list);
        System.out.println(result);
    }

    private String execute(ArrayList<String> list) {
        int kbs1Idx = 0;
        int kbs2Idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("KBS1")) {
                kbs1Idx = i;
                break;
            }
        }
        list.remove(kbs1Idx);
        list.add(0, "KBS1");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("KBS2")) {
                kbs2Idx = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1".repeat(kbs1Idx));
        sb.append("4".repeat(kbs1Idx));
        sb.append("1".repeat(kbs2Idx));
        sb.append("4".repeat(Math.max(0, kbs2Idx - 1)));
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
