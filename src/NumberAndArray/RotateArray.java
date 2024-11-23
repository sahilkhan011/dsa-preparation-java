package NumberAndArray;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        new RotateArray().rotate(new int[]{1,2,3,4,5},2);
    }
    public void rotate2(int[] nums, int k) {
        if(k > nums.length) {
            k = k % nums.length;
        }

        int[] tempArr = new int[k];
        for (int i = nums.length - k, j = 0; i < nums.length; i++, j++) {
            tempArr[j] = nums[i];
        }
        //System.out.println(Arrays.toString(tempArr));
        for (int i = nums.length-k-1; i>=0; i--) {
            System.out.println(nums[i]);
            nums[i+k]=nums[i];
        }
        for (int i = 0; i < tempArr.length; i++) {
            nums[i]=tempArr[i];
        }
        //System.out.println(Arrays.toString(nums));





    }
    public void rotate(int[]nums,int k){
        int n=nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    private void reverse(int[]nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
