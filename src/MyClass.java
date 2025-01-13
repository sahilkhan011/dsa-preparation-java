public class MyClass {
    public static void main(String[] args) {
        recursion(0,100);
        printTable(1,5);
        long factorialAns = factorial(5);
        System.out.println("\nfactorial Ans: "+factorialAns);
        long powerAns = findPower(5,5);
        System.out.println("\nPower Ans: "+powerAns);

    }

    private static long findPower(int num, int pow) {
        if(pow == 0) return 1;
        if(pow%2==1){
            return findPower(num,pow-1)*num;
        }else{
            return findPower(num*num,pow/2);
        }
    }

    private static long factorial(int i) {
        if(i==0) return 1;
        return factorial(i-1)*i;
    }

    private static void printTable(int i, int num) {
        System.out.print("\n"+i+ " * "+num+" = " +i*num);
        if(i==10){
            return;
        }
        i++;
        printTable(i,num);
    }

    private static void recursion(int i,int num) {
        if(i==num){
            return;
        }
        i++;
        recursion(i,num);
        System.out.print(i +" ");
    }
}
