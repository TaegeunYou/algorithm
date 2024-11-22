package main.java.baekjoon.gold._12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());
            products.add(new Product(w, v));
        }
        int result = process(k, products);
        System.out.println(result);
        br.close();
    }
    
    private int process(int k, ArrayList<Product> products) {
        int[] dp = new int[k + 1];
        for (Product product : products) {
            if (product.w > k) {
                continue;
            }
            for (int i = k; i >= product.w; i--) {
                dp[i] = Math.max(dp[i], dp[i - product.w] + product.v);
            }
        }
        return dp[k];
    }

    private class Product {
        int w;
        int v;

        public Product(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
