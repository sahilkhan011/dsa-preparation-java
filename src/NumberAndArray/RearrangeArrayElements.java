package NumberAndArray;

public class RearrangeArrayElements {
    public static void main(String[] args) {
        // Array Initialization.
        int[] A = {1, 2, -4, -5};
        int[] ans = rearrangeArray(A);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] resultArr = new int[nums.length];
        int posI = 0;
        int negI = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                resultArr[negI] = nums[i];
                negI += 2;
            } else {
                resultArr[posI] = nums[i];
                posI += 2;
            }
        }
        return resultArr;
    }
}
