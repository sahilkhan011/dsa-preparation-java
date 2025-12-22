package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem11 {
    public static void main(String[] args) {
        // ✨ 11. Find the second highest number in a list
        List<Integer> list = Arrays.asList(49,5,3,8,69,24,78,1,2,5,5,3,1,8,49,69,78,5,68,42,67);


        // solution one
        int max = list
                .stream()
                .max(Integer::compareTo).orElse(Integer.MIN_VALUE);

        int secondMax = list
                .stream()
                .filter(num -> num < max)
                .max(Integer::compareTo).orElse(Integer.MIN_VALUE);

        System.out.println(secondMax);

        // ===================================

        // solution two
        int ans = list
                .stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(Integer.MIN_VALUE);
    }
}
