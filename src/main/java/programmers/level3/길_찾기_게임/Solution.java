package main.java.programmers.level3.길_찾기_게임;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    int[] preorderArr;
    int[] postorderArr;
    int preorderArrIdx = 0;
    int postorderArrIdx = 0;

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        nodes.sort(Comparator.naturalOrder());
        Node parent = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            update(parent, node);
        }
        preorderArr = new int[nodeinfo.length];
        postorderArr = new int[nodeinfo.length];
        preorder(parent);
        postorder(parent);
        int[][] answer = new int[2][1];
        answer[0] = preorderArr;
        answer[1] = postorderArr;
        return answer;
    }

    private void update(Node parent, Node node) {
        if (node.x < parent.x) {   //왼쪽 자식
            if (parent.left == null) {
                parent.left = node;
            } else {
                update(parent.left, node);
            }
        } else {  //오른쪽 자식
            if (parent.right == null) {
                parent.right = node;
            } else {
                update(parent.right, node);
            }
        }
    }

    private void preorder(Node node) {
        if (node == null) {
            return;
        }
        preorderArr[preorderArrIdx++] = node.num;
        preorder(node.left);
        preorder(node.right);
    }

    private void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        postorderArr[postorderArrIdx++] = node.num;
    }

    private class Node implements Comparable<Node> {
        int num;
        int x;
        int level;
        Node left;
        Node right;

        public Node(int num, int x, int level) {
            this.num = num;
            this.x = x;
            this.level = level;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node o) {
            if (this.level == o.level) {
                return this.x - o.x;
            }
            return o.level - this.level;
        }
    }
}
