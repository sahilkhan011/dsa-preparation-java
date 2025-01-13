package Recurssion;

public class FindFibonacci {
    public static void main(String[] args) {
        int ans = findFibonacci(5);
        System.out.println(ans);  // Output the 5th Fibonacci number
    }
    // this solution is not recommended for best solution because it creates many unnessecery calls and rudundant calculation...
    private static int findFibonacci(int i) {
        if (i == 0) return 0;  // Base case: F(0) = 0
        if (i == 1) return 1;  // Base case: F(1) = 1
        return findFibonacci(i - 1) + findFibonacci(i - 2);  // Recursive case
    }
}

