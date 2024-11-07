package NumberAndArray;

public class IsPalindromeNumber {
    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome(45);
        System.out.println(isPalindrome);
    }
    public static boolean isPalindrome(int x) {
        if(x<0){return false;}
        int rev = 0;
        int num = x;
        while (num != 0) {
            int pop = num % 10; // Get the last digit
            num /= 10;          // Remove the last digit
            rev = rev * 10 + pop; // Build the reversed number
        }
        return rev==x;
    }
}
