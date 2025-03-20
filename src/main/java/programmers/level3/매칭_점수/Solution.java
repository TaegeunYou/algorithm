package main.java.programmers.level3.매칭_점수;

import java.util.*;

class Solution {
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        for (int i = 0; i < pages.length; i++) {
            pages[i] = pages[i].toLowerCase();
        }
        Map<Integer, String> idxToUrlMap = new HashMap<>();
        Map<String, Integer> urlToIdxMap = new HashMap<>();
        Map<Integer, Integer> basicMap = new HashMap<>();
        Map<Integer, Integer> outMap = new HashMap<>();
        Map<Integer, List<Integer>> inputMap = new HashMap<>();
        String metaStr = "<meta property=\"og:url\" content=\"https://";
        for (int i = 0; i < pages.length; i++) {
            String page = pages[i];
            int metaStartIdx = page.indexOf(metaStr);
            int startIdx = metaStartIdx + metaStr.length();
            int endIdx = page.indexOf("\"", startIdx) - 1;
            String url = page.substring(startIdx, endIdx + 1);
            idxToUrlMap.put(i, url);
            urlToIdxMap.put(url, i);
        }
        //기본 점수
        for (int i = 0; i < pages.length; i++) {
            String page = pages[i];
            char[] charArray = page.toCharArray();
            int beginIdx = 0;
            int sum = 0;
            while (true) {
                int startIdx = page.indexOf(word, beginIdx);
                int leftIdx = startIdx - 1;
                int rightIdx = startIdx + word.length();
                if (startIdx == -1) {
                    break;
                }
                beginIdx = startIdx + 1;
                if (leftIdx >= 0 && Character.isAlphabetic(page.charAt(leftIdx))) {
                    continue;
                }
                if (rightIdx < page.length() && Character.isAlphabetic(page.charAt(rightIdx))) {
                    continue;
                }
                sum++;
            }
            basicMap.put(i, sum);
        }
        //외부 링크 수
        String outStr = "<a href=\"https://";
        for (int i = 0; i < pages.length; i++) {
            String page = pages[i];
            char[] charArray = page.toCharArray();
            int beginIdx = 0;
            int sum = 0;
            while (true) {
                int startIdx = page.indexOf(outStr, beginIdx);
                if (startIdx == -1) {
                    break;
                }
                beginIdx = startIdx + 1;
                sum++;

                int urlStartIdx = startIdx + outStr.length();
                int urlEndIdx = page.indexOf("\"", urlStartIdx) - 1;
                String url = page.substring(urlStartIdx, urlEndIdx + 1);
                if (urlToIdxMap.get(url) != null) {
                    int inputIdx = urlToIdxMap.get(url);
                    List<Integer> inputs = inputMap.getOrDefault(inputIdx, new ArrayList<>());
                    inputs.add(i);
                    inputMap.put(inputIdx, inputs);
                }
            }
            outMap.put(i, sum);
        }
        double maxSum = -1;
        int maxIdx = 0;
        for (int i = 0; i < pages.length; i++) {
            double sum = 0;
            if (inputMap.get(i) != null) {
                for (int j : inputMap.get(i)) {
                    sum += (1.0 * basicMap.get(j) / outMap.get(j));
                }
            }
            sum += basicMap.get(i);
            if (sum > maxSum) {
                maxSum = sum;
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
