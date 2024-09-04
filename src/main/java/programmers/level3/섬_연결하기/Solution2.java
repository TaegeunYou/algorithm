package main.java.programmers.level3.섬_연결하기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 프림 알고리즘
 */
class Solution2 {

    public int solution(int n, int[][] costs) {
        int answer = 0;
        HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int dist = cost[2];
            ArrayList<Node> aConnects = map.getOrDefault(a, new ArrayList<>());
            aConnects.add(new Node(b, dist));
            map.put(a, aConnects);
            ArrayList<Node> bConnects = map.getOrDefault(b, new ArrayList<>());
            bConnects.add(new Node(a, dist));
            map.put(b, bConnects);
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0 ,0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visited[node.num]) continue;
            visited[node.num] = true;
            answer += node.cost;
            for (Node dest : map.get(node.num)) {
                if (visited[dest.num]) continue;
                queue.offer(dest);
            }
        }
        return answer;
    }

    class Node implements Comparable<Node>{
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }

    }

}