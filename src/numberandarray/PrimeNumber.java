package numberandarray;

public class PrimeNumber {
    public static void main(String[] args) {
        boolean isPrime = isPrimeNumber(45);
        System.out.println(isPrime);
    }

    private static boolean isPrimeNumber(int num) {
        if(num%2==0){
            return false;
        }
        for (int i = 3; i < Math.sqrt(num); i=i+2) {
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
