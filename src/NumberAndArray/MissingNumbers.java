package NumberAndArray;

public class MissingNumbers {
    public static void main(String[] args) {
        int missingNumber = new MissingNumbers().missingNumber(new int[]{0,4,5,1,2});
        System.out.println(missingNumber);
    }
    public int missingNumber(int[] nums) {
        int ans = (nums.length*(nums.length+1))/2;
        for (int i =0; i < nums.length; i++){
            ans -= nums[i];
        }
        return ans;
    }
}
