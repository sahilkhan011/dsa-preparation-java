package stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem1 {

    // ✅ 1. Count the occurrences of each character in a string


    public static void main(String[] args) {


        String str = "dashewiylkndjkvagoeij";

        solution(str);
    }

    private static void solution(String str) {
        IntStream inputStream = str.chars();

        Stream<Character> stream =
                inputStream.mapToObj(c -> (char) c);

        Map<Character, Long> result =
                stream.collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println(result);

    }
}
