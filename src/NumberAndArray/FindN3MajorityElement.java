package NumberAndArray;

import java.util.ArrayList;
import java.util.List;

public class FindN3MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        List<Integer> ans = majorityElement(arr);
        System.out.println("The majority elements are: " + ans);
    }

    private static List<Integer> majorityElement(int[] arr) {
        int e1 = 0, e2 = 0; // Potential candidates
        int c1 = 0, c2 = 0; // Counters for candidates

        // Step 1: Find potential candidates
        for (int num : arr) {
            if (c1 > 0 && num == e1) {
                c1++;
            } else if (c2 > 0 && num == e2) {
                c2++;
            } else if (c1 == 0) {
                e1 = num;
                c1++;
            } else if (c2 == 0) {
                e2 = num;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        // Step 2: Verify the candidates
        c1 = 0;
        c2 = 0;
        for (int num : arr) {
            if (num == e1) c1++;
            else if (num == e2) c2++;
        }

        List<Integer> result = new ArrayList<>();
        int threshold = arr.length / 3;

        if (c1 > threshold) result.add(e1);
        if (c2 > threshold) result.add(e2);

        return result;
    }
}
