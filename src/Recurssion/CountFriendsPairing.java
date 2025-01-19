package Recurssion;

public class CountFriendsPairing {
    public static void main(String[] args) {
        // Test the function with 3 friends
        int ans = solve(3);  // Using recursive approach
        System.out.println(ans);  // Expected output: 4

        int ans2 = solve2(3);  // Using iterative approach
        System.out.println(ans2);  // Expected output: 4
    }

    /*
    Problem: Given `n` friends, we need to find how many ways they can be paired up in groups of two or remain single.
    We assume that:
    - A friend can either stay single or form a pair with another friend.
    - The order of the pairs does not matter.

    There are two approaches to solving this problem:
    1. A recursive approach.
    2. An iterative approach using dynamic programming.
    */

    // Recursive solution
    private static int solve(int n) {
        // Base case: If there are 1 or 2 friends, there are n ways to arrange them
        if (n <= 2) return n;

        // Recurrence relation:
        // - solve(n-1): If the nth friend stays single.
        // - (n-1) * solve(n-2): If the nth friend pairs up with one of the (n-1) other friends.
        return solve(n - 1) + (n - 1) * solve(n - 2);
    }

    // Iterative (dynamic programming) solution
    private static int solve2(int n) {
        // Base cases for 1 and 2 friends
        int a = 1, b = 2, c = 2;

        // Start from the 3rd friend and calculate the number of ways for each subsequent number of friends
        for (int i = 3; i <= n; i++) {
            // Recurrence relation (similar to the recursive function but in an iterative form):
            // c = b + (i - 1) * a
            // - b: The number of ways for (i-1) friends (nth friend stays single).
            // - (i - 1) * a: The number of ways to pair the nth friend with any of the (i-1) other friends.
            c = b + (i - 1) * a;

            // Update values for the next iteration
            a = b;
            b = c;
        }
        return c;
    }
}
