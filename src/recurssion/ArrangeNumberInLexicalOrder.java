package recurssion;

import java.util.LinkedList;
import java.util.List;
// this solution is not recommended best solution is dfs...
public class ArrangeNumberInLexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new LinkedList<>();
        f(0,n,ans);
        return ans;
    }

    private void f(int i, int n, List<Integer> ans) {
        if(i <= n) {
            if(i!=0) ans.add(i);
        }else return;
        for (int j = 0; j < 10; j++) {
            if(i==0 && j==0) continue;
            f(i*10+j,n,ans);
        }
    }
}
