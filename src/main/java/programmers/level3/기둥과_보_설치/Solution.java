package main.java.programmers.level3.기둥과_보_설치;

import java.util.*;

class Solution {

    int n;
    boolean[][] pillars;
    boolean[][] ceils;
    Map<String, Boolean> map = new HashMap<>();
    List<Node> all = new ArrayList<>();

    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        pillars = new boolean[n + 1][n + 1];
        ceils = new boolean[n + 1][n + 1];
        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int a = build[2];
            int b = build[3];
            if (b == 0) {
                if (a == 0) {
                    removePillar(x, y);
                } else {
                    removeCeil(x, y);
                }
            } else {
                if (a == 0) {
                    buildPillar(x, y);
                } else {
                    buildCeil(x, y);
                }
            }
        }
        List<Node> nodes = new ArrayList<>();
        for (String key : map.keySet()) {
            String[] split = key.split(" ");
            nodes.add(new Node(
                Integer.parseInt(split[0]),
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2])
            ));
        }
        nodes.sort(Comparator.naturalOrder());
        int[][] answer = new int[nodes.size()][3];
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            answer[i][0] = node.x;
            answer[i][1] = node.y;
            answer[i][2] = node.a;
        }
        return answer;
    }

    private void removePillar(int x, int y) {
        pillars[x][y] = false;
        for (Node node : all) {
            if (node.a == 0 && !availPillar(node.x, node.y)) {
                pillars[x][y] = true;
                return;
            }
            if (node.a == 1 && !availCeil(node.x, node.y)) {
                pillars[x][y] = true;
                return;
            }
        }
        int idx = -1;
        for (int i = 0; i < all.size(); i++) {
            Node node = all.get(i);
            if (node.x == x && node.y == y && node.a == 0) {
                idx = i;
                break;
            }
        }
        all.remove(idx);
        map.remove(x + " " + y + " " + 0);
    }

    private void removeCeil(int x, int y) {
        ceils[x][y] = false;
        for (Node node : all) {
            if (node.a == 0 && !availPillar(node.x, node.y)) {
                ceils[x][y] = true;
                return;
            }
            if (node.a == 1 && !availCeil(node.x, node.y)) {
                ceils[x][y] = true;
                return;
            }
        }
        int idx = -1;
        for (int i = 0; i < all.size(); i++) {
            Node node = all.get(i);
            if (node.x == x && node.y == y && node.a == 1) {
                idx = i;
                break;
            }
        }
        all.remove(idx);
        map.remove(x + " " + y + " " + 1);
    }

    private boolean availPillar(int x, int y) {
        if (x < 0 || y < 0 || x > n || y > n) {
            return false;
        }
        if (y == 0 || pillars[x][y - 1] || ceils[x][y] || (x > 0 && ceils[x - 1][y])) {
            return true;
        }
        return false;
    }

    private boolean availCeil(int x, int y) {
        if (x < 0 || y < 0 || x > n || y > n) {
            return false;
        }
        if ((y > 0 && pillars[x][y - 1]) || (y > 0 && x + 1 <= n && pillars[x + 1][y - 1])) {
            return true;
        }
        if (x > 0 && x + 1 <= n && ceils[x - 1][y] && ceils[x + 1][y]) {
            return true;
        }
        return false;
    }


    private void buildPillar(int x, int y) {
        if (availPillar(x, y)) {
            pillars[x][y] = true;
            map.put(x + " " + y + " " + 0, true);
            all.add(new Node(x, y, 0));
        }
    }

    private void buildCeil(int x, int y) {
        if (availCeil(x, y)) {
            ceils[x][y] = true;
            map.put(x + " " + y + " " + 1, true);
            all.add(new Node(x, y, 1));
        }
    }

    private class Node implements Comparable<Node> {
        int x;
        int y;
        int a;

        public Node(int x, int y, int a) {
            this.x = x;
            this.y = y;
            this.a = a;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y == o.y && this.x == o.x) {
                return this.a - o.a;
            }
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

}
