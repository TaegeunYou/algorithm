package main.java.programmers.level2.숫자_변환하기;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        queue.offer(new Node(x, 0));
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            int a = tmp.num * 3;
            int b = tmp.num * 2;
            int c = tmp.num + n;
            if (a == y || b == y || c == y) return tmp.count + 1;
            if (a < y && map.get(a) == null) {
                map.put(a, true);
                queue.offer(new Node(a, tmp.count + 1));
            }
            if (b < y && map.get(b) == null) {
                map.put(b, true);
                queue.offer(new Node(b, tmp.count + 1));
            }
            if (c < y && map.get(c) == null) {
                map.put(c, true);
                queue.offer(new Node(c, tmp.count + 1));
            }
        }
        if (x == y) return 0;
        return -1;
    }

    public class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(1, 1, 1);
        System.out.println(solution1);
    }
}