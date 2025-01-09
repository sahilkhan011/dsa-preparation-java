package Recurssion;
import java.util.*;

public class GenerateAllBinaryStringWithoutConsecutiveOne {
    public static void main(String args[]) {
        int k = 3;
        //Calling function fun with argument k
         List<String> strList = generateAllBinaryString(k);
        for (String str : strList) {
            System.out.println(str+",");
        }
    }
    private static List<String> generateAllBinaryString(int k) {
        if (k <= 0) {
            return null;
        }
        char[] ch = new char[k];
        List<String> ans = new ArrayList<>();

        ch[0] = '0';
        generate(1,k,ch,ans);
        ch[0] = '1';
        generate(1,k,ch,ans);
        return ans;
    }

    public static void generate(int ind,int k,char [] ds, List<String> ans){
        if(ind == k){
            ans.add(Arrays.toString(ds));
            return;
        }
        if(ds[ind-1] == '0'){
            ds[ind] = '0';
            generate(ind+1,k,ds,ans);
            ds[ind] = '1';
            generate(ind+1,k,ds,ans);
        }
        if(ds[ind-1] == '1'){
            ds[ind] = '0';
            generate(ind+1,k,ds,ans);
        }
    }
}
