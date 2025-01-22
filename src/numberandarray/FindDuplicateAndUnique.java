package numberandarray;

import java.util.HashSet;

public class FindDuplicateAndUnique {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 2, 3, 4};
        System.out.println(findDuplicate(array));
        System.out.println(findUnique(array));
    }

    private static HashSet<Integer> findUnique(int[] array) {
        HashSet<Integer> uniqueSet = new HashSet<>();
        for (int j : array) {
            if (!uniqueSet.add(j)) {
                uniqueSet.remove(j);
            }
        }
        return uniqueSet;
    }

    private static HashSet<Integer> findDuplicate(int[] array) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicateSet = new HashSet<>();
        for (int j : array){
            if(!seen.add(j)){
                duplicateSet.add(j);
            }
        }
        return duplicateSet;
    }
}
