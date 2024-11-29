package NumberAndArray;

import java.util.HashMap;

public class LongestSubArrayWithSum {
    public static void main(String[] args) {
        int[] arr = {1,2,2,5,1,5,6,3,7,2};
        int ans = longestSubArrayWithSum(arr,5);
        System.out.println(ans);
    }

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
}
