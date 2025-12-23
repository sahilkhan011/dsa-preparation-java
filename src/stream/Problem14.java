package stream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem14 {
    public static void main(String[] args) {
        // ✨ 14. Partition a list into even and odd numbers

        List<Integer> numbers = Arrays.asList(45,56,4,89,39,22,89,36,54,243,657,5357,3567,35,73,453,54);

        List<Integer> evenNumbers = numbers.stream().filter(num -> num%2 == 0).toList();
        List<Integer> oddNumbers = numbers.stream().filter(num -> num%2 != 0).toList();

        System.out.println(evenNumbers);
        System.out.println(oddNumbers);

        //======================



        Map<Boolean,List<Integer>> partitioned  = numbers
                .stream()
                .collect(Collectors.partitioningBy(
                     num -> num % 2 == 0
                ));

        List<Integer> evenNums = partitioned.get(true);
        List<Integer> oddNums = partitioned.get(false);

        System.out.println(evenNums);
        System.out.println(oddNums);

    }
}
