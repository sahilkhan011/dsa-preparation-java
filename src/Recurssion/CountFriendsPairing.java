package Recurssion;

public class CountFriendsPairing {
    public static void main(String[] args) {
        int ans = solve(3);
        System.out.println(ans);
        int ans2 = solve2(3);
        System.out.println(ans2);
    }

    private static int solve2(int n) {
        int a = 1,b = 2,c = 2;
        for (int i = 3; i < n+1; i++) {
            c = b + ( (i-1) * a);
            a = b;
            b = c;
        }
        return c;
    }

    private static int solve(int i) {
        if(i<=2) return i;
        return solve(i-1) + solve(i-2) * (i-1);
    }


}
