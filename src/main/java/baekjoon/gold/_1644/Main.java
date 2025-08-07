package main.java.baekjoon.gold._1644;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> primes = generatePrimeArr(n);
        int result = execute(n, primes);
        System.out.println(result);
    }

    private int execute(int n, List<Integer> primes) {
        if (primes.isEmpty()) {
            return 0;
        }
        int lt = 0;
        int rt = 0;
        int sum = primes.get(lt);
        int size = primes.size();
        int answer = 0;
        while (lt <= rt) {
            while (sum < n && rt < size - 1) {
                rt++;
                sum += primes.get(rt);
            }
            if (sum == n) {
                answer++;
            }
            sum -= primes.get(lt);
            lt++;
        }
        return answer;
    }

    private List<Integer> generatePrimeArr(int n) {
        boolean[] notPrimeArr = new boolean[n + 1];
        for (int i = 2; i <= n / 2; i++) {
            for (int j = i * 2; j <= n; j += i) {
                if (j % i == 0) {
                    notPrimeArr[j] = true;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!notPrimeArr[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
