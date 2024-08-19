package main.java.programmers.level2.후보키;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

class Solution {

    int columnLength, rowLength;
    int[] ch;
    ArrayList<Integer> idxList = new ArrayList<>();
    ArrayList<ArrayList<Integer>> candidateAvailIdxList = new ArrayList<>();
    public int solution(String[][] relation) {
        this.rowLength = relation.length;
        this.columnLength = relation[0].length;
        ch = new int[columnLength];
        dfs(0, relation);
        candidateAvailIdxList.sort(Comparator.comparing(ArrayList::size));
        int idx = 0;
        while (idx < candidateAvailIdxList.size() - 1) {
            int len = candidateAvailIdxList.size();
            for (int i = len - 1; i > idx; i--) {
                boolean flag = true;
                for (int j : candidateAvailIdxList.get(idx)) {
                    if (!candidateAvailIdxList.get(i).contains(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) candidateAvailIdxList.remove(i);
            }
            idx++;
        }
        return candidateAvailIdxList.size();
    }

    private void dfs(int idx, String[][] relation) {
        if (!idxList.isEmpty() && check(relation)) {
            candidateAvailIdxList.add(new ArrayList<>(idxList));
        }
        if (idx == columnLength) return;
        for (int i = idx; i < columnLength; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                idxList.add(i);
                dfs(i + 1, relation);
                ch[i] = 0;
                idxList.remove(idxList.indexOf(i));
            }
        }
    }

    private boolean check(String[][] relation) {
        ArrayList<String> list = new ArrayList<>();
        for (String[] arr : relation) {
            StringBuilder tmp = new StringBuilder();
            for (int idx : idxList) {
                tmp.append(arr[idx]);
            }
            list.add(tmp.toString());
        }
        return rowLength == new HashSet<>(list).size();
    }

}