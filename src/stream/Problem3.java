package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem3 {

    public static void main(String[] args) {
        // ✅ 3. Identify duplicate elements in a list


        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 3);
        List<String> names = Arrays.asList("java", "spring", "boot", "java", "api", "spring");

        System.out.println("Duplicate numbers: " + duplicateItemList(numbers));
        System.out.println("Duplicate names: " + duplicateItemList(names));

    }

    public static <T> List<T> duplicateItemList(List<T> list) {

        return list.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),      // group by element itself
                        Collectors.counting()     // count occurrences
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)    // ✅ duplicates only
                .map((e)->e.getKey())           // extract duplicate element
                .collect(Collectors.toList());
    }

}
