package numberandarray;

import java.util.HashMap;

public class LongestSubArrayWithSum {
    public static void main(String[] args) {
        int[] arr = {1,2,2,5,1,5,6,3,7,2};
        int ans = longestSubArrayWithSum(arr,5);
        System.out.println(ans);
    }

    // this solution work in negative number case also.
    private static int longestSubArrayWithSum(int[] arr, int k) {
        HashMap<Long,Integer> map = new HashMap<>();
        long currentSum =0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            //calculate the prefix sum till index i:
            currentSum += arr[i];

            // if the sum = k, update the maxLen:
            if (currentSum==k){
                maxLen = Math.max(maxLen,i+1);
            }

            // calculate the sum of remaining part i.e. x-k:
            long rem = currentSum - k;

            //Calculate the length and update maxLen:
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen,len);
            }

            //Finally, update the map checking the conditions:
            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            }
        }
        return maxLen;
    }

    // this solution is best for positive number case.
    // it doesn't work in negative case.
    public static int getLongestSubarray(int []a, long k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }

}
