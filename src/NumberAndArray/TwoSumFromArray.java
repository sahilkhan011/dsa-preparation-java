package NumberAndArray;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumFromArray {
    public static void main(String[] args) {
        int[] nums = {5,45,69,15,6,8,10};
        int[] res = twoSum(nums,15);
        System.out.println(res[0]+","+res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++) {

            Integer requiredValueIndex = map.get(target - nums[i]);

            if(requiredValueIndex!=null){
                return new int[]{requiredValueIndex,i};
            }

            // set into map (value, index)
            map.put(nums[i], i);

        }
        return new int[]{};
    }

    public static int[] twoSumUsingPointer(int n, int []arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{left,right};
            } else if (sum < target) left++;
            else right--;
        }
        return new int[]{};
    }


}

