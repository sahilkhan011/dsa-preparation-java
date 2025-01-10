package twopointers;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int id=1;
        for(int i=1;i<nums.length;i++) {
            if (nums[i]!=nums[i-1]) {
                nums[id++] = nums[i];
            }
        }
        return id;
    }
}
