package main.java.inflearn.Recursive_Tree_Graph;

import main.java.inflearn.Recursive_Tree_Graph.Main0705.Node;

import java.util.Scanner;

public class Main0709 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        dfs(0, new Node(1));
    }

    static int dfs(int L, Node node) {
        if (node.lt == null && node.rt == null) return L;
        else return Math.min(dfs(L + 1, node.lt), dfs(L + 1, node.rt));
    }

}