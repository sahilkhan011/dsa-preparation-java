package NumberAndArray;

public class FindSingleAppearNumber {
    public static void main(String[] args) {
        // Sample input array where every number appears twice except one
        int[] nums = {4, 1, 2, 1, 2};

        // Call the singleNumber method and store the result
        int result = singleNumber(nums);

        // Print the result
        System.out.println("The number that appears only once is: " + result);
    }

    public static int singleNumber(int[] nums) {
        int xorr = 0;
        for (int i = 0; i < nums.length; i++) {
            xorr = xorr ^ nums[i];
        }
        return xorr;
    }
}
