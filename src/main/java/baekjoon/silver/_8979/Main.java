package main.java.baekjoon.silver._8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        ArrayList<Country> countries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Country country = new Country(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
            countries.add(country);
        }
        int result = execute(k, countries);
        System.out.println(result);
    }

    private int execute(int k, ArrayList<Country> countries) {
        Country target = get(k, countries);
        countries.sort(Comparator.naturalOrder());
        for (int i = 0; i < countries.size(); i++) {
            Country country = countries.get(i);
            if (country.gold == target.gold && country.silver == target.silver && country.bronze == target.bronze) {
                return i + 1;
            }
        }
        return -1;
    }

    private Country get(int k, ArrayList<Country> countries) {
        for (Country country : countries) {
            if (country.num == k) {
                return country;
            }
        }
        return null;
    }

    private class Country implements Comparable<Country> {
        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold == o.gold && this.silver == o.silver) {
                return o.bronze - this.bronze;
            }
            if (this.gold == o.gold) {
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
