package stream;

import java.util.stream.Collectors;

public class Problem10 {
    public static void main(String[] args) {
        // ✅ 10. Reverse a string using Stream operations

        String str = "sahil khan";

        // this is not optimal because of immutability of string

        String reversed = str.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .reduce("", (a, b) -> b + a);


        System.out.println(reversed);

        // optimal solution
        String rev = str.chars()
                .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append
                )
                .reverse()
                .toString();

        System.out.println(rev);

    }
}
