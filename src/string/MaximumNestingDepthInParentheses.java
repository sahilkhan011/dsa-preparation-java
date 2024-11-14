package string;

public class MaximumNestingDepthInParentheses {
    public static void main(String[] args) {
        System.out.println("Max Depth: " + maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    public static int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                currentDepth++;
                maxDepth = Math.max(currentDepth,maxDepth);
            } else if (s.charAt(i)==')') {
                currentDepth--;;
            }

        }
        return maxDepth;
    }
}
