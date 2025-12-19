package string;

import java.util.HashMap;
import java.util.HashSet;

public class AnagramString {
    public static void main(String[] args) {
        Boolean b = isAnagrams("CAT","TAC");
        System.out.println(b);
    }

    private static Boolean isAnagrams(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        int[] freq = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'A']++;
            freq[str2.charAt(i) - 'A']--;
        }

        for (int i = 0; i < 26; i++) {
            if(freq[i] !=0 ) return false;
        }
        return true;
    }
    private static boolean isAnagramsByMap(String str1,String str2){

        // edge case
        if(str1.length()!=str2.length()) return false;

        // define map to keep track of occurance of character
        HashMap<Character,Integer> map = new HashMap<>();

        // iterate through the first given string
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }


        // iterate through the second given string
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (!map.containsKey(c)) return false;
            map.put(c,map.get(c)-1);
            if(map.get(c)==0){
                map.remove(c);
            }
        }
        return map.isEmpty();
    }


}
