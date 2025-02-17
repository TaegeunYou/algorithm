package main.java.programmers.level3.표_편집;

import java.util.*;

class Solution {

    private class Node {
        int num;
        Node front;
        Node back;

        public Node(int num, Node front, Node back) {
            this.num = num;
            this.front = front;
            this.back = back;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        Deque<Node> stack = new ArrayDeque<>();
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i, null, null));
        }
        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0) {
                nodes.get(i).front = nodes.get(i - 1);
            }
            if (i + 1 < nodes.size()) {
                nodes.get(i).back = nodes.get(i + 1);
            }
        }
        Node node = nodes.get(k);
        for (String str : cmd) {
            char tmpCmd = str.charAt(0);
            if (tmpCmd == 'U') {
                int move = Integer.parseInt(str.split(" ")[1]);
                for (int i = 0; i < move; i++) {
                    node = node.front;
                }
            } else if (tmpCmd == 'D') {
                int move = Integer.parseInt(str.split(" ")[1]);
                for (int i = 0; i < move; i++) {
                    node = node.back;
                }
            } else if (tmpCmd == 'C') {
                stack.offerLast(node);
                Node front = node.front;
                Node back = node.back;
                if (front != null) {
                    front.back = back;
                }
                if (back != null) {
                    back.front = front;
                }
                if (node.back == null) {
                    node = front;
                } else {
                    node = back;
                }
            } else if (tmpCmd == 'Z') {
                Node tmp = stack.pollLast();
                if (tmp.front != null) {
                    tmp.front.back = tmp;
                }
                if (tmp.back != null) {
                    tmp.back.front = tmp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (node.front != null) {
            node = node.front;
        }
        for (int i = 0; i < n; i++) {
            if (node == null || i < node.num) {
                sb.append("X");
            } else {
                sb.append("O");
                node = node.back;
            }
        }
        return sb.toString();
    }
}
