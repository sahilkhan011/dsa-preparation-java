package NumberAndArray;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {5,5,0,1,1,1};
        int ans = findMaxConsecutiveOnes(arr);
        System.out.println(ans);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }

            maxi = Math.max(maxi, cnt);
        }
        return maxi;
    }
}
