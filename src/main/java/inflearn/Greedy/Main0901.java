package main.java.inflearn.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 5
 * 172 67
 * 183 65
 * 180 70
 * 170 72
 * 181 60
 */
class Main0901 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(in.nextInt(), in.nextInt());
        }
        Arrays.sort(people, Comparator.comparing(it -> it.height));
        int answer = people.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (people[j].weight > people[i].weight) {
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    public static class Person {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }


    }

}