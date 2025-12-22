package stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem13 {
    public static void main(String[] args) {
        // ✨ 13. Group objects by a specific field (e.g., department)

        List<Employee> employees = List.of(
                new Employee(1, "Alice", "IT", 60000),
                new Employee(2, "Bob", "HR", 45000),
                new Employee(3, "Charlie", "IT", 70000),
                new Employee(4, "David", "Finance", 50000),
                new Employee(5, "Eva", "HR", 48000)
        );


        Map<String,List<Employee>> empByDept = employees
                                                .stream()
                                                .collect(Collectors.groupingBy(
                                                        e ->e.department
                                                ));


        // Print result
        empByDept.forEach((dept, emps) ->
                System.out.println(dept + " -> " + emps)
        );
    }

    static class Employee {
        int id;
        String name;
        String department;
        double salary;

        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return name + "(" + salary + ")";
        }
    }
}
