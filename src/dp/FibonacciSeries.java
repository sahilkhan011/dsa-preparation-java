package dp;
public class FibonacciSeries {
    public static void main(String[] args) {
        int res = find(8);
        System.out.println(res);

    }

    private static int find(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
