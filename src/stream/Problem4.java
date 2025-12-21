package stream;

import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static void main(String[] args) {
        // ✅ 4. Find the maximum and minimum values in a list using Streams


        solution(Arrays.asList(1, 2, 3, 2, 4, 1, 5, 3));
    }

    private static void solution(List<Integer> list) {
        int min = list.stream()
                .min(Integer::compareTo).orElse(Integer.MIN_VALUE);

        int max = list.stream()
                .max(Integer::compareTo).orElse(Integer.MAX_VALUE);

        System.out.println("min value is : "+ min);
        System.out.println("max value is : "+ max);


    }
}
