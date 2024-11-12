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
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            if(map.containsKey(str1.charAt(i))){
               int val = map.get(str1.charAt(i))+1;
               map.replace(str1.charAt(i),val);
            }
            else{
                map.put(str1.charAt(i),1);
            }

            if(map.containsKey(str2.charAt(i))){
                int val = map.get(str2.charAt(i))-1;
                map.replace(str2.charAt(i),val);
            }
            else{
                map.put(str2.charAt(i),-1);
            }

        }
        for (Character key : map.keySet()){
            if(map.get(key) != 0) return false;
        }
        return true;
    }


}
