package NumberAndArray;

public class ReverseInteger {
    public static void main(String[] args) {
        int revNum = reverse(456);
        System.out.println(revNum);
    }

    public static int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            int pop = num % 10; // Get the last digit
            num /= 10;          // Remove the last digit

            // Check for overflow
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            rev = rev * 10 + pop; // Build the reversed number
        }
        return rev;
    }
}
