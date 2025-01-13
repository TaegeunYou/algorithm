package main.java.baekjoon.gold._2179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Word> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Word(i, br.readLine()));
        }
        execute(list);
    }

    private void execute(List<Word> list) {
        Map<String, List<Word>> map = new HashMap<>();
        list.sort(Comparator.naturalOrder());
        int maxLength = Integer.MIN_VALUE;
        String maxPrefix = null;
        int maxPrefixSmallIdx = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            String prefix = get(list.get(i), list.get(i + 1), map);
            int prefixSmallIdx = Math.min(list.get(i).idx, list.get(i + 1).idx);
            if (prefix.length() >= maxLength) {
                if (prefix.length() == maxLength) {
                    if (prefixSmallIdx < maxPrefixSmallIdx) {
                        maxLength = prefix.length();
                        maxPrefix = prefix;
                        maxPrefixSmallIdx = prefixSmallIdx;
                    }
                } else {
                    maxLength = prefix.length();
                    maxPrefix = prefix;
                    maxPrefixSmallIdx = prefixSmallIdx;
                }
            }
        }
        List<Word> words = map.get(maxPrefix);
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        String strA = null;
        String strB = null;
        for (Word word : new HashSet<>(words)) {
            if (word.idx < a) {
                b = a;
                strB = strA;
                a = word.idx;
                strA = word.str;
                continue;
            }
            if (word.idx < b) {
                b = word.idx;
                strB = word.str;
            }
        }
        System.out.println(strA);
        System.out.println(strB);
    }

    private String get(Word word1, Word word2, Map<String, List<Word>> map) {
        for (int i = 0; i < word1.str.length(); i++) {
            if (i >= word2.str.length() || word1.str.charAt(i) != word2.str.charAt(i)) {
                String prefix = word1.str.substring(0, i);
                List<Word> list = map.getOrDefault(prefix, new ArrayList<>());
                list.addAll(Arrays.asList(word1, word2));
                map.put(prefix, list);
                return prefix;
            }
        }
        List<Word> list = map.getOrDefault(word1.str, new ArrayList<>());
        list.addAll(Arrays.asList(word1, word2));
        map.put(word1.str, list);
        return word1.str;
    }

    private class Word implements Comparable<Word> {
        int idx;
        String str;

        public Word(int idx, String str) {
            this.idx = idx;
            this.str = str;
        }

        @Override
        public int compareTo(Word o) {
            return this.str.compareTo(o.str);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
