package twopointers;

public class SortTwoColors {
    public static void main(String[] args) {
        int[] arr = {0,1,0,1,1,1,1,0,0,1,0,1,1,1,1,};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    // sort 0 and 1
    public static void sort(int[] num) {
        int left = 0, right = num.length - 1;

        while (left < right) {
            if (num[left] == 0) {
                left++;
            } else if (num[right] == 1) {
                right--;
            } else {
                // Swap 1 (left side) with 0 (right side)
                int tmp = num[left];
                num[left] = num[right];
                num[right] = tmp;
                left++;
                right--;
            }
        }
    }
}
