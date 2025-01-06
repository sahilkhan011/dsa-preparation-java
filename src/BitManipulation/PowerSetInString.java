package BitManipulation;

import java.util.*;

public class PowerSetInString {
    public static ArrayList<String> AllPossibleStrings(String s) {
        int n = s.length();
        ArrayList<String>ans=new ArrayList<>();
        for (int num = 0; num < ( 1 << n ); num++) {
            StringBuilder tmpStr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                // check bit is set or not
                if((num & (1 << i)) != 0){
                    tmpStr.append(s.charAt(i));
                }
            }
            if(!tmpStr.isEmpty()){
                ans.add(tmpStr.toString());
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
