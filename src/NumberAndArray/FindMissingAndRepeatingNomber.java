package NumberAndArray;

public class FindMissingAndRepeatingNomber {

    public static int[] betterSolution(int[] a) {
        int n = a.length; // size of the array
        int repeating = -1;
        int sum = 0;

        // Frequency array to count occurrences
        int[] hash = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hash[a[i]]++;
            if (hash[a[i]] == 2) {
                repeating = a[i]; // Found the repeating number
            }
            sum += a[i];
        }

        // Total sum of 1 to n
        int expectedSum = n * (n + 1) / 2;

        // Find the missing number
        int missing = expectedSum - (sum - repeating);

        // Return the results
        int[] ans = {repeating, missing};
        return ans;

    }

    public static int[] bruteForceSolution(int[] a) {
        int n = a.length; // size of the array
        int repeating = -1, missing = -1;

        //Find the repeating and missing number:
        for (int i = 1; i <= n; i++) {
            //Count the occurrences:
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] == i) cnt++;
            }

            if (cnt == 2) repeating = i;
            else if (cnt == 0) missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        int[] ans = {repeating, missing};
        return ans;
    }

}
