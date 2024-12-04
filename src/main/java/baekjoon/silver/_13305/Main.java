package main.java.baekjoon.silver._13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dist = new int[n - 1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st1.nextToken());
        }
        ArrayList<City> cities = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cities.add(new City(i, Integer.parseInt(st2.nextToken())));
        }
        long result = execute(n, dist, cities);
        System.out.println(result);
    }

    private long execute(int n, int[] dist, ArrayList<City> cities) {
        long cost = 0;
        int cityIdx = n - 1;
        Collections.sort(cities);
        for (City city : cities) {
            if (city.idx >= cityIdx) {
                continue;
            }
            for (int i = city.idx; i < cityIdx; i++) {
                cost += ((long) dist[i] * city.price);
            }
            cityIdx = city.idx;
        }
        return cost;
    }

    private class City implements Comparable<City> {
        int idx;
        int price;

        public City(int idx, int price) {
            this.idx = idx;
            this.price = price;
        }

        @Override
        public int compareTo(City o) {
            return this.price - o.price;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
