package main.java.programmers.level2.도넛과_막대_그래프;

import java.util.*;

class Solution {
    int[][] edges;
    HashMap<Integer, Boolean> ch;
    HashMap<Integer, ArrayList<Integer>> forwardMap;
    HashMap<Integer, ArrayList<Integer>> backwardMap;
    TreeSet<Integer> nodes;
    int[] answer;
    public int[] solution(int[][] edges) {
        answer = new int[4];
        this.edges = edges;
        //정점찾기
        int addNode = findAddNode();
        answer[0] = addNode;
        //정점이 가리키는 간선 제외 리스트
        forwardMap = new HashMap<>();
        backwardMap = new HashMap<>();
        nodes = new TreeSet<>();
        int remove = 0;
        for (int[] edge : edges) {
            nodes.add(edge[0]);
            nodes.add(edge[1]);
            if (edge[0] == addNode || edge[1] == addNode) {
                remove++;
                continue;
            }
            ArrayList<Integer> forwardList = forwardMap.getOrDefault(edge[0], new ArrayList<>());
            ArrayList<Integer> backwardList = backwardMap.getOrDefault(edge[1], new ArrayList<>());
            forwardList.add(edge[1]);
            backwardList.add(edge[0]);
            forwardMap.put(edge[0], forwardList);
            backwardMap.put(edge[1], backwardList);
        }
        nodes.remove(addNode);
        //bfs로 그래프 분석
        ch = new HashMap<>();
        for (int node : nodes) {
            if (ch.get(node) != null) continue;
            ch.put(node, true);
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                int queueSize = queue.size();
                for (int j = 0; j < queueSize; j++) {
                    Integer num = queue.pollFirst();
                    ArrayList<Integer> forwardList = forwardMap.get(num) == null ? new ArrayList<>() : forwardMap.get(num);
                    ArrayList<Integer> backwardList = backwardMap.get(num) == null ? new ArrayList<>() : backwardMap.get(num);
                    ArrayList<Integer> connectList =  new ArrayList<>();
                    for (int i : forwardList) {
                        if (!connectList.contains(i)) connectList.add(i);
                    }
                    for (int i : backwardList) {
                        if (!connectList.contains(i)) connectList.add(i);
                    }
                    if (backwardList.isEmpty()) {
                        answer[2]++;     //막대
                    } else if (forwardList.size() == 2 && backwardList.size() == 2) {
                        answer[3]++;     //팔자
                    }
                    for (int connect : connectList) {
                        if (ch.get(connect) == null) {
                            ch.put(connect, true);
                            queue.offerLast(connect);
                        }
                    }
                }
            }
        }
        answer[1] = remove - (answer[2] + answer[3]);       //도넛
        return answer;
    }

    private int findAddNode() {
        int addNode = -1;
        HashMap<Integer, Integer> forwardCountMap = new HashMap<>();
        HashMap<Integer, Integer> backwardCountMap = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            forwardCountMap.put(a, forwardCountMap.getOrDefault(a, 0) + 1);
            backwardCountMap.put(b, backwardCountMap.getOrDefault(b, 0) + 1);
        }
        for (Integer key : forwardCountMap.keySet()) {
            if (forwardCountMap.get(key) > 1 && backwardCountMap.get(key) == null) {
                addNode = key;
                break;
            }
        }
        return addNode;
    }
}