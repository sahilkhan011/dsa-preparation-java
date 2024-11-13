package NumberAndArray;

import java.util.Arrays;

public class MostFrequentInArray {
    public static void main(String[] args) {
        int ans = maxFrequency(new int[]{1,4,8,13},5);
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=1;
        long total = 0;
        for (int i = 1,j=0; i < nums.length; i++) {
            total += (long) (nums[i] - nums[i - 1]) * (i - j);
            while (total > k) {
                total -= nums[i] - nums[j++];
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
