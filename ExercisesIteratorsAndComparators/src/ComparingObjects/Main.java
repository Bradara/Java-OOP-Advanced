package ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Person> persons = new ArrayList<>();
        String line;
        String[] input;

        while (!(line = br.readLine()).equalsIgnoreCase("ENd")) {
            input = line.split("\\s+");
            persons.add(new Person(input[0], Integer.valueOf(input[1]), input[2]));
        }

        Person nThPerson = persons.get(Integer.parseInt(br.readLine())-1);
        long equalPeople = persons.stream().filter(p -> p.compareTo(nThPerson) == 0).count();

        if (equalPeople > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(equalPeople).append(" ");
            sb.append(checkForNumberOfNotEqual(persons)).append(" ");
            sb.append(persons.size());
            System.out.println(sb);
        } else {
            System.out.println("No matches");
        }
    }

    private static int checkForNumberOfNotEqual(List<Person> persons) {
        int count = 0;

        for (int i = 0; i < persons.size(); i++) {
            Person temp = persons.get(i);
            long numberOfEqualPersons = persons.stream().filter(p -> p.compareTo(temp) == 0).count();
            if (numberOfEqualPersons==1) {
                count++;
            }
        }

        return  count;
    }
}
