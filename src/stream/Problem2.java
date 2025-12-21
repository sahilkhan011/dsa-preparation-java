package stream;


import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        // ✅ 2. Find the first non-repeated character in a string
        String str = "asuoenvdaasdioflk";

        char c = solution(str);
    }

    private static char solution(String str) {

        char ch = str
                .chars()                          // converts String to IntStream
                .mapToObj(c -> (char) c)          // converts IntStream to Stream<Character>
                .collect(Collectors.groupingBy(  // groups characters and counts occurrences
                        Function.identity(),      // character itself as key
                        LinkedHashMap::new,       // preserves insertion order
                        Collectors.counting()     // counts occurrences
                ))
                .entrySet()                       // converts Map to Set<Map.Entry>
                .stream()                         // converts entry set to Stream
                .filter(e -> e.getValue() == 1)   // keeps only non-repeated characters
                .map((e)->e.getKey())           // extracts the character (key)
                .findFirst()                      // gets the first non-repeated character
                .orElse('\0');                    // no non-repeated character found

        return ch;
    }

}
