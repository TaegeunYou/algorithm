package main.java.inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Main0111 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        ArrayList<Pair> pairs = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (!pairs.isEmpty() && pairs.getLast().key == c) {
                pairs.getLast().addCount();
            } else {
                pairs.add(new Pair(c));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Pair pair : pairs) {
            sb.append(pair.key);
            sb.append(pair.count);
        }
        String answer = sb.toString().replaceAll("1", "");
        System.out.println(answer);
    }

    public static class Pair {
        char key;
        int count;

        public Pair(char key) {
            this.key = key;
            this.count = 1;
        }

        public void addCount() {
            this.count++;
        }
    }

}