package string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static void main(String[] args) {
        String str1 = "paper";
        String str2 = "title";
        boolean isIsomorphic = isIsomorphic(str1,str2);
        if (isIsomorphic){
            System.out.println("String is Isomorphic");
        }else{
            System.out.println("String is not Isomorphic");
        }
    }

    private static boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (map1.containsKey(char1)){
                if (map1.get(char1) != char2){
                    return false;
                }
            }else{
                map1.put(char1,char2);
            }

            if (map2.containsKey(char2)){
                if (map2.get(char2) != char1){
                    return false;
                }
            }else{
                map2.put(char2,char1);
            }

        }
        return true;
    }
}
