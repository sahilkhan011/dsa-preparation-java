package numberandarray;

public class CountGoodNumbers {

    static int mod = 1000000007;
    public static long pow(int x,long y)
    {
        if(y==0)
            return 1;
        long ans=pow(x,y/2);
        ans*=ans;
        ans%=mod;
        if(y%2==1)
            ans*=x;
        ans%=mod;
        return ans;
    }
    public static int countGoodNumbers(long n) {
        long odd=n/2,even=(n+1)/2;
        long ans=   (pow(5,even)*pow(4,odd))%mod;
        return (int)ans;
    }

    public static void main(String[] args) {
        int n = 5; // Length of the number
        long count = countGoodNumbers(n);
        System.out.println("Count of good numbers of length " + n + ": " + count);
    }
}

