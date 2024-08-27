package main.java.programmers.level3.단어_변환;

class Solution {
    int end = Integer.MAX_VALUE;
    boolean flag = false;
    public int solution(String begin, String target, String[] words) {
        int[] ch = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (avail(begin, words[i])) {
                ch[i] = 1;
                dfs(words[i], target, ch, 1, words);
                ch[i] = 0;
            }
        }
        return flag ? end : 0;
    }

    private void dfs(String tmp, String target, int[] ch, int count, String[] words) {
        if (tmp.equals(target)) {
            end = Math.min(end, count);
            flag = true;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (ch[i] == 0 && avail(tmp, words[i])) {
                ch[i] = 1;
                dfs(words[i], target, ch, count + 1, words);
                ch[i] = 0;
            }
        }
    }

    private boolean avail(String a, String b) {
        if (a.length() != b.length()) return false;
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff <= 1;
    }
}