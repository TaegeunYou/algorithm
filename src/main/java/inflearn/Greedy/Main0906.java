package main.java.inflearn.Greedy;

import java.util.Scanner;

/**
 * 9 7
 * 1 2
 * 2 3
 * 3 4
 * 1 5
 * 6 7
 * 7 8
 * 8 9
 * 3 8
 */
class Main0906 {

    static int[] unf;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            union(a, b);
        }
        int fa = find(in.nextInt());
        int fb = find(in.nextInt());
        if (fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    static int find(int a) {
        if (a == unf[a]) return a;
        else return unf[a] = find(unf[a]);
    }

}