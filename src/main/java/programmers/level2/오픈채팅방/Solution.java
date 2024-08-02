package main.java.programmers.level2.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * record	result
 * ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
 */
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = record.length - 1; i >= 0; i--) {
            String[] split = record[i].split(" ");
            String action = split[0];
            String id = split[1];
            if (!action.equals("Leave") && map.get(id) == null) {
                map.put(id, split[2]);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (String str : record) {
            String[] split = str.split(" ");
            String action = split[0];
            String id = split[1];
            String finalName = map.get(id);
            if (action.equals("Enter")) {
                list.add(finalName + "님이 들어왔습니다.");
            } else if (action.equals("Leave")) {
                list.add(finalName + "님이 나갔습니다.");
            }
        }
        return list.toArray(String[]::new);
    }
}