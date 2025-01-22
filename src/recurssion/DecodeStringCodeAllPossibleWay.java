package recurssion;

import java.util.ArrayList;
import java.util.List;

public class DecodeStringCodeAllPossibleWay {
    public static void main(String[] args) {
        String code = "85121215";  // Example input
        List<String> decodedStrings = decodeWays(code);
        System.out.println(decodedStrings);  // Output all possible decodings
    }

    private static List<String> decodeWays(String code) {
        List<String> ans = new ArrayList<>();
        recurse(0,code,new StringBuilder(),ans);
        return  ans;
    }

    private static void recurse(int i, String str, StringBuilder ds, List<String> ans) {
        if(i==str.length()){
            ans.add(ds.toString());
            return;
        }

        // Case 1: Decode the current single digit (1 to 9) -> maps to 'A' to 'I'
        int digit = str.charAt(i) - '0';  // Convert char to int
        if (digit >= 1 && digit <= 9) {  // Check if valid range (A-I)
            ds.append((char) ('A' + digit - 1));  // Convert to corresponding char
            recurse(i + 1, str, ds, ans);  // Continue recursion with next character
            ds.deleteCharAt(ds.length() - 1);  // Backtrack
        }

        // Case 2: Decode the current two digits (10 to 26) -> maps to 'J' to 'Z'
        if (i + 1 < str.length()) {  // Ensure there are at least two digits left
            int twoDigits = Integer.parseInt(str.substring(i, i + 2));  // Get the two-digit number
            if (twoDigits >= 10 && twoDigits <= 26) {  // Check if valid range (J-Z)
                ds.append((char) ('A' + twoDigits - 1));  // Convert to corresponding char
                recurse(i + 2, str, ds, ans);  // Continue recursion with next two digits
                ds.deleteCharAt(ds.length() - 1);  // Backtrack
            }
        }
    }
}
