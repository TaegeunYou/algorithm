package main.java.programmers.level2.순위_검색;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Query[] queryArr = new Query[query.length];
        for (int i = 0; i < query.length; i++) {
            queryArr[i] = new Query(query[i], i);
        }
        HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();
        String[] languages = new String[]{"cpp", "java", "python"};
        String[] types = new String[]{"backend", "frontend"};
        String[] levels = new String[]{"junior", "senior"};
        String[] foods = new String[]{"chicken", "pizza"};
        for (String student : info) {
            String[] studentSplit = student.split(" ");
            String studentLanguage = studentSplit[0];
            String studentType = studentSplit[1];
            String studentLevel = studentSplit[2];
            String studentFood = studentSplit[3];
            int studentScore = Integer.parseInt(studentSplit[4]);
            String key = studentLanguage + studentType + studentLevel + studentFood;
            PriorityQueue<Integer> scores = map.getOrDefault(key, new PriorityQueue<>());
            scores.offer(studentScore);
            map.put(key, scores);
        }
        Arrays.sort(queryArr, (str1, str2) -> {
            String[] split1 = str1.str.split(" ");
            String[] split2 = str2.str.split(" ");
            return Integer.parseInt(split1[split1.length - 1]) - Integer.parseInt(split2[split2.length - 1]);
        });
        for (int i = 0; i < queryArr.length; i++) {
            String q = queryArr[i].str;
            String[] split = q.split(" ");
            String queryLangauge = split[0];
            String queryType = split[2];
            String queryLevel = split[4];
            String queryFood = split[6];
            int score = Integer.parseInt(split[7]);
            String[] queryLanguages = queryLangauge.equals("-") ? languages : new String[]{ queryLangauge };
            String[] queryTypes = queryType.equals("-") ? types : new String[]{ queryType };
            String[] queryLevels = queryLevel.equals("-") ? levels : new String[]{ queryLevel };
            String[] queryFoods = queryFood.equals("-") ? foods : new String[]{ queryFood };
            for (String language : queryLanguages) {
                for (String type : queryTypes) {
                    for (String level : queryLevels) {
                        for (String food : queryFoods) {
                            String key = language + type + level + food;
                            PriorityQueue<Integer> students = map.get(key);
                            if (students == null) continue;
                            while (!students.isEmpty() && students.peek() < score) {
                                students.poll();
                            }
                            answer[queryArr[i].idx] += students.size();
                        }
                    }
                }
            }
        }
        return answer;
    }

    class Query {
        String str;
        int idx;

        public Query(String str, int idx) {
            this.str = str;
            this.idx = idx;
        }
    }

}