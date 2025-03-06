package main.java.programmers.level3.코딩_테스트_공부;

import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer_alp = -1;
        int answer_cop = -1;
        for (int[] problem : problems) {
            answer_alp = Math.max(answer_alp, problem[0]);
            answer_cop = Math.max(answer_cop, problem[1]);
        }
        int[][] record = new int[answer_alp + 1][answer_cop + 1];
        for (int[] arr : record) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(Math.min(answer_alp, alp), Math.min(answer_cop, cop), 0));
        int minTime = Integer.MAX_VALUE;
        for (int t = 0; t < 301; t++) {
            int len = queue.size();
            if (len == 0) {
                break;
            }
            for (int i = 0; i < len; i++) {
                Node node = queue.pollFirst();
                if (node.alp == answer_alp && node.cop == answer_cop) {
                    record[answer_alp][answer_cop] = Math.min(record[answer_alp][answer_cop], node.time);
                    minTime = record[answer_alp][answer_cop];
                    continue;
                }
                if (node.time >= record[node.alp][node.cop]) {
                    continue;
                }
                record[node.alp][node.cop] = node.time;
                if (minTime > node.time + 1) {
                    queue.offerLast(new Node(Math.min(answer_alp, node.alp + 1), node.cop, node.time + 1));
                    queue.offerLast(new Node(node.alp, Math.min(answer_cop, node.cop + 1), node.time + 1));
                }
                for (int[] problem : problems) {
                    if (node.alp >= problem[0] && node.cop >= problem[1]) {
                        int tmpAlp = Math.min(answer_alp, node.alp + problem[2]);
                        int tmpCop = Math.min(answer_cop, node.cop + problem[3]);
                        Node tmp = new Node(tmpAlp, tmpCop, node.time + problem[4]);
                        if (tmp.time < minTime) {
                            queue.offerLast(tmp);
                        }
                    }
                }
            }
        }
        return record[answer_alp][answer_cop];
    }

    private class Node {
        int alp;
        int cop;
        int time;

        public Node(int alp, int cop, int time) {
            this.alp = alp;
            this.cop = cop;
            this.time = time;
        }
    }
}
