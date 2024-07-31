package main.java.programmers.level2.튜플;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * "{{2},{2,1},{2,1,3},{2,1,3,4}}"	[2, 1, 3, 4]
 */
class Solution {
    public int[] solution(String s) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || i == s.length() - 1) continue;
            char c = s.charAt(i);
            if (c == '{') {
                list.add(new ArrayList<>());
            } else if (Character.isDigit(c)) {
                str += (c - '0');
            } else if (!str.isEmpty()) {
                list.get(list.size() - 1).add(Integer.parseInt(str));
                str = "";
            }
        }
        list.sort(Comparator.comparing(ArrayList::size));
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> tmp : list) {
            for (int i : tmp) {
                if (!result.contains(i)) {
                    result.add(i);
                    break;
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        new Solution().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }
}