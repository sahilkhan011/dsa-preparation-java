package Recurssion;

public class ThePowerSum {
    static NumPowerAndRoot obj = new NumPowerAndRoot();
    public static void main(String[] args) {
        int ans = solve(100,2);
        System.out.println(ans);
    }

    private static int solve(int x, int n) {
        int range = obj.findBaseRoot(x,n);
        return recurse(x,n,1,range);
    }

    private static int recurse(int x, int n, int i, int range) {
        if(x == 0){ return 1;}
        if(x < 0 || i > range){ return 0;}

        int include = recurse(x-(int) Math.pow(i, n),n,i+1,range);
        int exclude = recurse(x,n,i+1,range);
        return include + exclude;
    }


}
