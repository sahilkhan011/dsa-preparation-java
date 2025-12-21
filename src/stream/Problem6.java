package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static void main(String[] args) {
        // ✅ 6. Convert a List into a Map using Java Streams
        List<Problem5.Person> people = Arrays.asList(
                new Problem5.Person("Alice", 25),
                new Problem5.Person("Bob", 20),
                new Problem5.Person("Charlie", 30)
        );


        // create map with name and age.. if name is unique in given list...
        Map<String,Integer> map = people
                .stream()
                .collect(Collectors.toMap(
                        p -> p.name,
                        p -> p.age
                ));

        // create map with name and occurance of same name ..
        Map<String, Long> newMap = people.stream()
                .collect(Collectors.groupingBy(
                        p -> p.name,
                        Collectors.counting()
                ));

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
