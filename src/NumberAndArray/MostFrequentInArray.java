package NumberAndArray;

import java.util.Arrays;

public class MostFrequentInArray {
    public static void main(String[] args) {
        int ans = maxFrequency(new int[]{1,4,8,13},5);
        int ans1 = maxFrequency(new int[]{1},5);
        System.out.println(ans1);
    }

    // this problem is solved using sliding window.
    // in this solution we keep tracking of need.
    // in each iteration increase need and right pointer (i).
    // whenever need goes to greater than k.
    // we reduce need and increase left pointer (j), until need is equal or less than k

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=1;
        long need = 0;
        for (int i = 1,j=0; i < nums.length; i++) {
            // increase need after increasing right pointer
            need += (long) (nums[i] - nums[i - 1]) * (i - j);
            // System.out.println(need);

            // decrease need and increase left pointer until need is not smaller or equal to k.
            while (need > k) {
                need -= nums[i] - nums[j++];
                // System.out.println("after reduce need:"+need);
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
