package main.java.inflearn.Recursive_Tree_Graph;

import java.util.*;

public class Main0713 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int key = in.nextInt();
            ArrayList<Integer> tmpMap = map.getOrDefault(key, new ArrayList<>());
            tmpMap.add(in.nextInt());
            map.put(key, tmpMap);
        }
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>(Arrays.asList(1)));
        while (!queue.isEmpty()) {
            ArrayList<Integer> nodeList = queue.poll();
            for (int i : nodeList) {
                ArrayList<Integer> tmpList = new ArrayList<>();
                Collections.copy(tmpList, nodeList);
                for (int j : map.get(i)) {

                }

            }
        }
    }

}