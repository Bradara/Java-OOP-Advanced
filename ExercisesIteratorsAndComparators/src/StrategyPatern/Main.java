package StrategyPatern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> peopleByName = new TreeSet<>(new ComparotorByName());
        Set<Person> personHashSet = new HashSet<>();
        int n = Integer.valueOf(br.readLine());
        String[] line;

        while (n-->0) {
            line = br.readLine().split("\\s+");
            Person p = new Person(line[0], Integer.parseInt(line[1]));
            //System.out.println(p.hashCode());
            peopleByName.add(p);
            personHashSet.add(p);
        }

        System.out.println(peopleByName.size());

        System.out.println(personHashSet.size());
    }
}
