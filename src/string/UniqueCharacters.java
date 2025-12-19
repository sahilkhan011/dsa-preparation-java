package string;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharacters {

    //“if string is adddeeci print aci — print only those characters which appear once.”

    public static void main(String[] args) {
        String s = "adddeeci";
        System.out.println(getUniqueCharacters(s));
    }

    private static String getUniqueCharacters(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        StringBuilder ans = new StringBuilder();
        for(char c: map.keySet()){
            if(map.get(c)==1) ans.append(c);
        }
        return ans.toString();
    }
}
