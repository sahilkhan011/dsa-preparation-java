package NumberAndArray;

public class FindN2MajorityElement {
    public static void main(String args[]) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);
        System.out.println("The majority element is: " + ans);

    }

    private static int majorityElement(int[] arr) {
        int element = 0;
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if(c==0){
                c++;
                element = arr[i];
            } else if (arr[i]==element) {
                c++;
            }
            else{
                c--;
            }
        }
        return element;
    }
}
