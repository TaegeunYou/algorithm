package main.java.inflearn.Stack_Queue;

import java.util.*;

public class Main0508 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Queue<Wrapper> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Wrapper(in.nextInt()));
        }
        Wrapper mth = queue.stream().toList().get(m);
        int max = Collections.max(queue, Comparator.comparingInt(w -> w.num)).num;
        int answer = 0;
        while (!queue.isEmpty()) {
            Wrapper tmp = queue.poll();
            if (tmp.num == max) {
                answer++;
                if (tmp == mth) {
                    break;
                } else {
                    max = Collections.max(queue, Comparator.comparingInt(w -> w.num)).num;
                }
            } else {
                queue.offer(tmp);
            }
        }
        System.out.println(answer);
    }

    static class Wrapper {
        public int num;

        public Wrapper(int num) {
            this.num = num;
        }

    }

}