package main.java.inflearn.Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5
 * 172 67
 * 183 65
 * 180 70
 * 170 72
 * 181 60
 */
class Main0901_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(in.nextInt(), in.nextInt());
        }
        Arrays.sort(people);
        int max = Integer.MIN_VALUE;
        int answer = 0;
        for (Person person : people) {
            if (person.weight > max) {
                answer++;
                max = person.weight;
            }
        }
        System.out.println(answer);
    }

    public static class Person implements Comparable<Person> {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }

}