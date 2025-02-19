package main.java.programmers.level3.양과_늑대;

import java.util.*;

class Solution {

    List<Node> nodes;
    int maxSheep = 1;
    List<Node> availNodes = new ArrayList<>();

    public int solution(int[] info, int[][] edges) {
        nodes = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            nodes.add(new Node(i, info[i]));
        }
        for (int i = 0; i < edges.length; i++) {
            Node parent = nodes.get(edges[i][0]);
            Node child = nodes.get(edges[i][1]);
            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        Node root = nodes.get(0);
        dfs(root, 0, 0);
        return maxSheep;
    }

    private void dfs(Node node, int sheep, int wolf) {
        if (node == null) {
            return;
        }
        if (node.type == 0) {
            sheep++;
        } else {
            wolf++;
        }
        if (sheep == wolf) {
            return;
        }
        maxSheep = Math.max(maxSheep, sheep);

        if (node.left != null) {
            availNodes.add(node.left);
        }
        if (node.right != null) {
            availNodes.add(node.right);
        }

        for (int i = 0; i < availNodes.size(); i++) {
            Node tmp = availNodes.get(i);
            availNodes.remove(tmp);
            dfs(tmp, sheep, wolf);
            availNodes.add(i, tmp);
        }

        if (node.left != null) {
            availNodes.remove(node.left);
        }
        if (node.right != null) {
            availNodes.remove(node.right);
        }
    }

    private class Node {
        int num;
        int type;
        Node left = null;
        Node right = null;

        public Node(int num, int type) {
            this.num = num;
            this.type = type;
        }
    }

}
