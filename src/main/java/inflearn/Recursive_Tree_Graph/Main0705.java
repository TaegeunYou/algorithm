package main.java.inflearn.Recursive_Tree_Graph;

import java.util.Scanner;

public class Main0705 {

    static class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        recursive(new Node(n));
    }

    static void recursive(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        recursive(node.lt);
        recursive(node.rt);
    }

}