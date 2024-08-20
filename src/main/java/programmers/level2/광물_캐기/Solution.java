package main.java.programmers.level2.광물_캐기;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    HashMap<String, Integer> pointMap;
    int[] ch;
    String[] minerals;
    int[] importanceArr;
    public int solution(int[] picks, String[] minerals) {
        this.minerals = refactorMinerals(picks, minerals);
        pointMap = getPointMap();
        importanceArr = getImportanceArr();
        ch = new int[this.minerals.length / 5 + 1];
        int diamond = execute("diamond", picks[0]);
        int iron = execute("iron", picks[1]);
        int stone = execute("stone", picks[2]);
        return diamond + iron + stone;
    }

    private String[] refactorMinerals(int[] picks, String[] minerals) {
        int len = Math.min(Arrays.stream(picks).sum() * 5, minerals.length);
        String[] strings = new String[len];
        for (int i = 0; i < len; i++) {
            strings[i] = minerals[i];
        }
        return strings;
    }

    private HashMap<String, Integer> getPointMap() {
        HashMap<String, Integer> map = new HashMap();
        map.put("diamond" + "diamond", 1);
        map.put("diamond" + "iron", 1);
        map.put("diamond" + "stone", 1);
        map.put("iron" + "diamond", 5);
        map.put("iron" + "iron", 1);
        map.put("iron" + "stone", 1);
        map.put("stone" + "diamond", 25);
        map.put("stone" + "iron", 5);
        map.put("stone" + "stone", 1);
        return map;
    }

    private int[] getImportanceArr() {
        HashMap<String, Integer> importanceMap = new HashMap<>();
        importanceMap.put("diamond", 100);
        importanceMap.put("iron", 10);
        importanceMap.put("stone", 1);

        int arrSize = (minerals.length-1) / 5 + 1;
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                int tmpIdx = i * 5 + j;
                if (tmpIdx >= minerals.length) break;
                sum += importanceMap.get(minerals[tmpIdx]);
            }
            arr[i] = sum;
        }
        return arr;
    }

    private int execute(String equip, int equipCount) {
        int result = 0;
        for (int j = 0; j < equipCount; j++) {
            int maxIdx = -1;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < importanceArr.length; i++) {
                if (importanceArr[i] > max && ch[i] == 0) {
                    max = importanceArr[i];
                    maxIdx = i;
                }
            }
            if (maxIdx == -1) break;
            ch[maxIdx] = 1;
            for (int i = 0; i < 5; i++) {
                int tmpIdx = maxIdx * 5 + i;
                if (tmpIdx >= minerals.length) break;
                result += pointMap.get(equip + minerals[maxIdx * 5 + i]);
            }
        }
        return result;
    }

}