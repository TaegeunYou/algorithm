package main.java.programmers.level2._3차_방금그곡;

import java.util.ArrayList;

/**
 * C, C#, D, D#, E, F, F#, G, G#, A, A#, B
 *    c      d         f       g     a
 */
class Solution {
    public String solution(String m, String[] musicinfos) {
        m = replace(m);
        ArrayList<Music> list = new ArrayList<>();
        for (String music : musicinfos) {
            list.add(new Music(music));
        }
        Music maxDurationMusic = null;
        for (Music music : list) {
            int count = music.duration / music.content.length();
            int remain = music.duration % music.content.length();
            String full = music.content.repeat(count * music.content.length()) + music.content.substring(0, remain + 1);
            if (full.contains(m)) {
                if (maxDurationMusic == null || maxDurationMusic.duration < music.duration) {
                    maxDurationMusic = music;
                }
            }
        }
        if (maxDurationMusic == null) return "(None)";
        else return maxDurationMusic.title;
    }

    private String replace(String str) {
        return str.replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a");
    }

    private int getMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    class Music {
        String start;
        String end;
        String title;
        String content;
        int duration;

        public Music(String music) {
            String[] split = music.split(",");
            this.start = split[0];
            this.end = split[1];
            this.title = split[2];
            this.content = replace(split[3]);
            this.duration = getMinutes(end) - getMinutes(start);
        }
    }

}