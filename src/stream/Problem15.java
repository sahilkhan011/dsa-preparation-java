package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem15 {
    public static void main(String[] args) {
        // ✨ 15. Find the longest string in a list

        List<String> listStr = Arrays.asList(
                "a",
                "be",
                "cat",
                "java",
                "stream",
                "lambda",
                "function",
                "collection",
                "programming",
                "development",
                "microservices",
                "architecture",
                "synchronization",
                "multithreading",
                "configuration",
                "dependency",
                "performance",
                "optimization",
                "responsibility",
                "characterization"
        );


        // solution one. using max

        String longest = listStr.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println(longest);

        // solution two. using reduce
        String longAns = listStr.stream()
                .reduce((s1, s2) ->
                        s1.length() >= s2.length() ? s1 : s2
                )
                .orElse("");

        System.out.println(longAns);


    }
}
