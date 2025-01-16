package string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String res = longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(res);
    }

    public static String longestCommonPrefix(String[] strs) {
        // Check for empty input
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string as the initial prefix
        String prefix = strs[0];

        // Compare with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix until it matches the start of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static String findPrefixBetweenTwoString(String s1,String s2){
        String prefix = s1;
        while(prefix.indexOf(s2)!=0){
            prefix = prefix.substring(0,prefix.length()-1);
            if(prefix.isEmpty()) return "";
        }
        return s1;
    }
}
