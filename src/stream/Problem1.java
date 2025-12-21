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

        // Converts the String into an IntStream of character ASCII values
        IntStream inputStream = str.chars();

        // Converts IntStream into Stream<Character>
        Stream<Character> stream =
                inputStream.mapToObj(c -> (char) c);

        // Groups characters and counts their occurrences
        Map<Character, Long> result =
                stream.collect(Collectors.groupingBy(
                        Function.identity(),     // character itself as the key
                        Collectors.counting()    // counts occurrences of each character
                ));

        // Prints the character frequency map
        System.out.println(result);
    }

}
