package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem9 {
    public static void main(String[] args) {
        // ✅ 9. Remove duplicates from a list using Streams

        List<Integer> list = Arrays.asList(49,5,3,8,69,24,78,1,2,5,5,3,1,8,49,69,78,5,68,42,67);

        // correct but not optimal
        List<Integer> uniqueList = list
                                .stream()
                                .collect(Collectors.toSet())
                                .stream()
                                .toList();

        // most optimal solution...
        List<Integer> uniqueList2 = list
                .stream()
                .distinct()
                .toList();


    }
}
