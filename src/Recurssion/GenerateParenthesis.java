package Recurssion;
import java.util.*;

public class GenerateParenthesis {
    int stepCount = 0;
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0,0,n,"",ans);
        return ans;
    }

    public void generate(int openCount,int closeCount,int n,String ds, List<String> ans){
        if(openCount > n || closeCount > n || closeCount > openCount){
            return;
        }
        if(openCount == n && closeCount == n){
            ans.add(ds);
            return;
        }
        generate(openCount+1,closeCount,n,ds+"(",ans);
        generate(openCount,closeCount+1,n,ds+")",ans);
    }

    public static void main(String[] args) {
        GenerateParenthesis obj = new GenerateParenthesis();
        List<String> strList = obj.generateParenthesis(3);
        for (String str : strList) {
            System.out.println(str+",");
        }
    }
}
