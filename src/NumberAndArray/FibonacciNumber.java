package NumberAndArray;


public class FibonacciNumber {
    public static void main(String[] args) {
        int num = 10;
        System.out.println("Fibonacci Number of "+num+" is: "+fib(num));
    }

    private static int fib(int num) {
        if(num<=0) return 0;
        else if(num==1) return 1;

        int fib1 = 0;
        int fib2 = 1;

        System.out.print("["+fib1+", "+fib2);
        int i=2;
        while(i<=num){
            int temp = fib2;
            fib2 = fib1 + fib2;
            fib1 = temp;
            i++;

            System.out.print(", "+fib2);
        }
        System.out.println("]");
        return fib2;
    }
}
