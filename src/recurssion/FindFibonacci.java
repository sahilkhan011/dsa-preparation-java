package recurssion;

public class FindFibonacci {
    public static void main(String[] args) {
        int ans = findFibonacci(5);
        System.out.println(ans);  // Output the 5th Fibonacci number
    }
    // this solution is not recommended for best solution because it creates many unnessecery calls and rudundant calculation...
    private static int findFibonacci(int i) {
        if (i == 0 || i == 1) return i;  // Base case: F(0) = 0 and Base case: F(1) = 1
        return findFibonacci(i - 1) + findFibonacci(i - 2);  // Recursive case
    }
}

