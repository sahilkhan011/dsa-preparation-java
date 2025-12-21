package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem8 {
    public static void main(String[] args) {
        // ✅ 8. Find the frequency of each element in a list

        List<Integer> list = Arrays.asList(49,5,3,8,69,24,78,1,2,5,5,3,1,8,49,69,78,5,68,42,67);

        Map<Integer,Long> map = list
                                .stream()
                                .collect(Collectors.groupingBy(
                                        Function.identity(), // (num) -> num, // also correct
                                        Collectors.counting()
                                ));

        for(Map.Entry<Integer,Long> entry : map.entrySet()){
            System.out.println("Key: "+entry.getKey()+", value: "+entry.getValue());
        }
    }
}
