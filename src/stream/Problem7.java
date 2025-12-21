package stream;

import java.util.Arrays;
import java.util.List;

public class Problem7 {
    public static void main(String[] args) {
        // ✅ 7. Calculate the sum and average of a list of numbers

         List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 3);

         int sum = list
                 .stream()
                 .reduce(0,(acc,num)-> acc + num);

        System.out.println("Sum of list is : " + sum);

        double avg = list
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        System.out.println("average of list is : "+avg);



        List<Person> peoples = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 20),
                new Person("Charlie", 30)
        );


        double avgSalary = peoples.stream()
                .mapToDouble(p -> p.salary)
                .average()
                .orElse(0.0);

        System.out.println("average salary is : "+avgSalary);

    }

    static class Person {
        String name;
        double salary;

        Person(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
    }

}
