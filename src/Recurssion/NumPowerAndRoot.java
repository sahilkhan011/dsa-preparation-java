package Recurssion;

public class NumPowerAndRoot {

    // Method to calculate base raised to the exponent using recursion
    public int findNumPower(int base, int exponent) {
        if (exponent == 0) {
            return 1;  // Any number raised to 0 is 1
        } else if (exponent < 0) {
            return 1 / findNumPower(base, -exponent);  // Handling negative exponents
        } else {
            return base * findNumPower(base, exponent - 1);  // Recursive step
        }
    }

    public int findBaseRoot(int number, int root) {
        int i = 1;
        while (Math.pow(i, root) <= number) {
            i++;
        }
        return i - 1; // Return the largest i such that i^N <= X
    }

    public static void main(String[] args) {
        NumPowerAndRoot obj = new NumPowerAndRoot();

        // Test Power calculation: 2^3 = 8
        int powerResult = obj.findNumPower(2, 3);
        System.out.println("2 to the power 3 is: " + powerResult);

        // Test Root calculation: Cube root of 8 = 2
        int rootResult = obj.findBaseRoot(8, 3);  // Find the cube root of 8
        System.out.println("The cube root of 8 is: " + rootResult);  // Expected: 2

        // Test Square root of 9 = 3
        int rootResult2 = obj.findBaseRoot(9, 2);  // Find the square root of 9
        System.out.println("The square root of 9 is: " + rootResult2);  // Expected: 3

        // Test Root for a number that is not a perfect square (e.g., sqrt(10) is not an integer)
        int rootResult3 = obj.findBaseRoot(10, 2);  // Find the square root of 10
        System.out.println("The square root of 10 is: " + rootResult3);  // Expected: Rounded value
    }
}
