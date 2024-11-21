package NumberAndArray;

public class CheckArraySortedAndRotated {
    public static void main(String[] args) {
        System.out.println(check(new int[]{5,6,7,1,3}));
    }
    public static boolean check(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[ (i+1) % nums.length]){
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return true;
    }
}
