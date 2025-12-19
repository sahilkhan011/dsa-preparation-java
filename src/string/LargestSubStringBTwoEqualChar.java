package string;
import java.util.HashMap;
import java.util.Map;

public class LargestSubStringBTwoEqualChar {
    // using map..
    public int maxLengthBetweenEqualCharactersUsingMap(String s) {
        int maxLen = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                maxLen = Math.max(maxLen, i - map.get(s.charAt(i)) - 1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        return maxLen;
    }

    // using array..
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLen = -1;
        int[] indices = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (indices[idx]>0) {
                maxLen = Math.max(maxLen, i - indices[idx] - 1);
            } else {
                indices[idx] = i;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LargestSubStringBTwoEqualChar obj = new LargestSubStringBTwoEqualChar();

        // Test case 1
        String testString1 = "abca";
        System.out.println("Max length between equal characters for " + testString1 + ": " + obj.maxLengthBetweenEqualCharacters(testString1));

        // Test case 2
        String testString2 = "abc";
        System.out.println("Max length between equal characters for " + testString2 + ": " + obj.maxLengthBetweenEqualCharacters(testString2));

        // Test case 3
        String testString3 = "aa";
        System.out.println("Max length between equal characters for " + testString3 + ": " + obj.maxLengthBetweenEqualCharacters(testString3));

        // Test case 4
        String testString4 = "abcdedcba";
        System.out.println("Max length between equal characters for " + testString4 + ": " + obj.maxLengthBetweenEqualCharacters(testString4));
    }


    // most fav approach
    // first reverse whole array..
    // than reverse each word..
    // than reverse last remember word

    public static String reverseWordsUsingReverseApproach(String str){
        char [] arr = str.toCharArray();

        // reverse whole string
        reverse(arr,0,arr.length-1);

        int l = 0;
        for (int r = 0; r < arr.length; r++) {
            if(arr[r]==' '){
                // reverse each word
                reverse(arr,l,r-1);
                l=r+1;
            }
        }

        // reverse last word
        reverse(arr,l,arr.length-1);

        return new String(arr);
    }
    public static void reverse(char[] arr, int left, int right){
        while(left<right){

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;

        }
    }
}
