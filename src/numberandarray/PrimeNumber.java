package numberandarray;

public class PrimeNumber {
    public static void main(String[] args) {
        boolean isPrime = isPrimeNumber(29);
        System.out.println(isPrime);
    }

    private static boolean isPrimeNumber(int num) {
        if (num <= 1) {
            return false; // 0 and 1 are not prime
        }
        if (num == 2 || num == 3) {
            return true; // 2 and 3 are prime numbers
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false; // multiples of 2 or 3 are not prime
        }

        // Check only odd numbers from 5 to sqrt(num), skipping multiples of 2 and 3
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
