package main.java.inflearn.Recursive_Tree_Graph;

import main.java.inflearn.Recursive_Tree_Graph.Main0705.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main0707 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1));
        int level = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Node tmp = queue.poll();
                System.out.println(level + " : " + tmp.data);
                if (tmp.lt != null) queue.offer(tmp.lt);
                if (tmp.rt != null) queue.offer(tmp.rt);
            }
            level++;
        }
    }

}