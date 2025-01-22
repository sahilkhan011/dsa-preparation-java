package recurssion;
import java.util.*;

public class FindAllUniqueSubsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findAllSubSets(0,nums,ans,new ArrayList<>());
        return ans;
    }
    public void findAllSubSets(int ind, int[] nums, List<List<Integer>> ans, List<Integer> ds){
        ans.add(new ArrayList<>(ds));
        for(int i = ind; i < nums.length; i++){
            if(i!=ind && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            findAllSubSets(i+1,nums,ans,ds);
            ds.removeLast();
        }
    }
}
