package Recurssion;

public class FindPow {
    public static double findPow(int x,int n){
        double ans = 1.0;
        int nn = n;
        if(n<0)  nn = -1 * nn;

        while(nn >0){
            if(nn % 2 == 1){
                ans = ans * x;
                nn = nn - 1;
            }
            else{
                x = x * x;
                nn = nn / 2;
            }
        }

        if(n<0) ans = 1.0 / ans;
        return ans;
    }

    public static void main(String[] args) {
        double ans = findPow(5,5);
        System.out.println(ans);
    }
}
