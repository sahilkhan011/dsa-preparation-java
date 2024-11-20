package string;

public class LongestPalindromeSubString {
    public static void main(String[] args) {
        String palindromeSubString = longestPalindrome("abbd");
        System.out.println(palindromeSubString);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // Odd length palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // Even length palindromes
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }

    private static boolean isPalindrome(String str, int start,int end){
        while(end>start){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end++;
        }
        return true;
    }
    private static String longestPalindromeSecondSolution(String str){
        int max = 0,start = 0,end = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if(isPalindrome(str,i,j)){
                    if(j-i+1 > max){
                        max = j-i+1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return str.substring(start,end+1);
    }

}
