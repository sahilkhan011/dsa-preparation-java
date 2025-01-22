package numberandarray;

import java.util.*;

public class FindAllSubarraysWithSum {

    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        Map<Integer, Integer> mpp = new HashMap<>(); // Map for storing prefix sum counts.
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Initialize with sum 0 having count 1.

        for (int i = 0; i < n; i++) {
            // Add current element to the prefix sum
            preSum += arr[i];

            // Calculate the sum needed to form a subarray with sum k
            int remove = preSum - k;

            // If remove exists in map, it means there is a subarray with sum k
            cnt += mpp.getOrDefault(remove, 0);

            // Update the prefix sum count in the map
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        int cnt = findAllSubarraysWithGivenSum(arr, k);
        System.out.println("The number of subarrays with sum " + k + " is: " + cnt);
    }
}
