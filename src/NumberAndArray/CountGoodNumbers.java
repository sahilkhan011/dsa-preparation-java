package NumberAndArray;

public class CountGoodNumbers {

    // Predefined sets for valid digits
    private static final int[] EVEN_DIGITS = {0, 2, 4, 6, 8};
    private static final int[] ODD_PRIME_DIGITS = {2, 3, 5, 7};

    public static void main(String[] args) {
        int n = 4; // Length of the number
        long count = countGoodNumbers(n);
        System.out.println("Count of good numbers of length " + n + ": " + count);
    }

    public static long countGoodNumbers(int n) {
        long evenCount = (n + 1) / 2; // Number of even index positions
        long oddCount = n / 2;        // Number of odd index positions

        // Calculate total possibilities:
        // - 5 choices for each even index (0, 2, 4, 6, 8)
        // - 4 choices for each odd index (2, 3, 5, 7)
        long totalGoodNumbers = (long) Math.pow(5, evenCount) * (long) Math.pow(4, oddCount);

        return totalGoodNumbers;
    }
}

