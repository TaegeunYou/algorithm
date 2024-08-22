package main.java.programmers.level3.정수_삼각형;

import java.util.ArrayDeque;

//메모리 초과
class Solution {
    public int solution(int[][] triangle) {
        if (triangle.length == 0) return 0;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(triangle[0][0], triangle[0][0], 0, 0));
        while (queue.getFirst().level + 1 != triangle.length) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node tmp = queue.pollFirst();
                if (tmp.level >= triangle.length - 1) break;
                int leftNum = triangle[tmp.level + 1][tmp.idx];
                int rightNum = triangle[tmp.level + 1][tmp.idx + 1];
                Node left = new Node(leftNum, tmp.sum + leftNum, tmp.level + 1, tmp.idx);
                Node right = new Node(rightNum, tmp.sum + rightNum, tmp.level + 1, tmp.idx + 1);
                queue.offerLast(left);
                queue.offerLast(right);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Node node : queue) {
            if (node.sum > max) max = node.sum;
        }
        return max;
    }

    class Node {
        int num;
        int sum;
        int level;
        int idx;

        public Node(int num, int sum, int level, int idx) {
            this.num = num;
            this.sum = sum;
            this.level = level;
            this.idx = idx;
        }
    }
}