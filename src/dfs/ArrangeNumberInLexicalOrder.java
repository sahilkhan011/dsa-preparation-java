package dfs;

import java.util.LinkedList;
import java.util.List;

public class ArrangeNumberInLexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new LinkedList<>();
        if(n<10){
            for(int i = 1; i<=n; i++){
                ans.add(i);
            }
        }else{
            // Start with 1 and generate numbers in lexical order
            for (int i = 1; i < 10 ; i++) {
                dfs(i, n, ans);
            }
        }
        return ans;
    }

    private void dfs(int current, int n, List<Integer> ans) {
        if (current > n) {
            return;
        }
        ans.add(current);
        for (int i = 0; i <= 9; i++) {
            // Recursively try the next number in lexical order
            if (current * 10 + i <= n) {
                dfs(current * 10 + i, n, ans);
            } else {
                break;
            }
        }
    }
}
