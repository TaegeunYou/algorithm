package main.java.baekjoon.silver._7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            people.add(new Person(x, y));
        }
        StringBuilder sb = new StringBuilder();
        for (Person target : people) {
            int num = execute(target, people);
            sb.append(num).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private int execute(Person target, List<Person> people) {
        int result = 1;
        for (Person person : people) {
            if (person == target) {
                continue;
            }
            if (target.x < person.x && target.y < person.y) {
                result++;
            }
        }
        return result;
    }

    private class Person {
        int x;
        int y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
