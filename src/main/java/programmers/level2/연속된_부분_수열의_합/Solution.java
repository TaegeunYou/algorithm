package main.java.programmers.level2.연속된_부분_수열의_합;

import java.util.ArrayList;
import java.util.Collections;

class Solution {

    public int[] solution(int[] sequence, int k) {
        int lt = 0;
        int rt = 0;
        int sum = sequence[0];
        ArrayList<Node> nodes = new ArrayList<>();
        while (true) {
            System.out.println(lt + " " + rt);
            if (sum == k) nodes.add(new Node(lt, rt));
            if (rt == sequence.length - 1 && rt == lt) break;
            if (sum <= k && rt < sequence.length - 1) {
                rt++;
                sum += sequence[rt];
            } else if (lt < rt) {
                sum -= sequence[lt];
                lt++;
            }
        }
        Collections.sort(nodes);
        Node node = nodes.get(0);
        return new int[]{node.lt, node.rt};
    }

    class Node implements Comparable<Node>{
        int lt;
        int rt;

        public Node(int lt, int rt) {
            this.lt = lt;
            this.rt = rt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.rt - this.lt == o.rt - o.lt) {
                return this.lt - o.lt;
            } else {
                return (this.rt - this.lt) - o.rt - o.lt;
            }
        }
    }

}