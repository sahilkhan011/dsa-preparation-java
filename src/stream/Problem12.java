package stream;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem12 {
    public static void main(String[] args) {
        // ✨ 12. Check if two strings are anagrams using Streams

        String str1 = "silent",str2 = "listen";

        boolean b = isAnagram(str1,str2);

        System.out.println(b);


    }

    private static boolean isAnagram(String str1, String str2) {
        return str1
                .chars()
                .mapToObj(c-> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).equals(
                        str2
                                .chars()
                                .mapToObj(c-> (char) c)
                                .collect(Collectors.groupingBy(
                                        Function.identity(),
                                        Collectors.counting()
                                ))
                );
    }
}
