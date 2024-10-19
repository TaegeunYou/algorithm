package main.java.algolab._study.CountBit;

public class main {
    private void solution() {
        int n = 4;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += (log2(i) + 1);
        }
        System.out.println("count = " + count);
        /*
        1  1
        2 10
        3 11
        4 100
        5 101
        ..
        7 111
        8 1000
         */
    }

    private int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    public static void main(String[] args) {
        new main().solution();
    }
}
