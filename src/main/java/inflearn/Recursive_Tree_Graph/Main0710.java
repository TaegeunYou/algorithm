package main.java.inflearn.Recursive_Tree_Graph;

import main.java.inflearn.Recursive_Tree_Graph.Main0705.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main0710 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1));
        int level = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
//                if (node == null) continue;
                if (node.lt == null && node.rt == null) return level;
                else {
                    if (node.lt != null) queue.offer(node.lt);
                    if (node.rt != null) queue.offer(node.rt);
                }
            }
            level++;
        }
        return 0;
    }
}