package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Problem5 {

    public static void main(String[] args) {

        // ✅ 5. Sort a list of objects based on a specific field

        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 20),
                new Person("Charlie", 30)
        );

        // ✅ Sort by age
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(p -> p.age))
                .collect(Collectors.toList());


        // **** .sorted(Comparator.comparing(p -> p.name))
        // this is static method that is used for object comparision
        // and  p.name is extracting key to compare..
        // it returns object of Comparator...

        System.out.println("Sorted by age: " + sortedByAge);

        // ✅ Sort by name
        List<Person> sortedByName = people.stream()
                .sorted(Comparator.comparing(p -> p.name))
                .collect(Collectors.toList());

        System.out.println("Sorted by name: " + sortedByName);
    }

    // Make it static so it can be instantiated in static main
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }
}
