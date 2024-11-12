package string;

public class RotateShiftProblem {
    public static boolean canShift(String s, String goal) {
        // Check if lengths are the same
        if (s.length() != goal.length()) {
            return false;
        }

        // Create a new string by concatenating s with itself
        String doubledS = s + s;

        // Check if goal is a substring of the doubled string
        return doubledS.contains(goal);
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(canShift("abcde", "cdeab")); // Output: true
        System.out.println(canShift("abcde", "abced"));  // Output: false
    }
}
