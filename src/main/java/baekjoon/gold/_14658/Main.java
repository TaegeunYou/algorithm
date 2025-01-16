package main.java.baekjoon.gold._14658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int l = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        List<Star> stars = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            stars.add(new Star(y, x));
        }
        int result = execute(l, stars);
        System.out.println(result);
    }

    private int execute(int l, List<Star> stars) {
        int max = 0;
        for (int i = 0; i < stars.size(); i++) {
            for (int j = 0; j < stars.size(); j++) {
                Star star1 = stars.get(i);
                Star star2 = stars.get(j);
                if (Math.abs(star1.x - star2.x) > l || Math.abs(star1.y - star2.y) > l) {
                    continue;
                }
                int x = Math.min(star1.x, star2.x);
                int y = Math.min(star1.y, star2.y);
                int count = 0;
                for (Star star : stars) {
                    if (star.x >= x && star.x <= x + l && star.y >= y && star.y <= y + l) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        return stars.size() - max;
    }

    private class Star implements Comparable<Star> {
        int x;  //세로
        int y;  //가로

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Star o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
