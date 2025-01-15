package Recurssion;

public class PatternSolution {
    public static void main(String[] args) {
        printPattern(1,5);
        printP(1,1,5);
    }

    // pattern using 2 function..
    private static void printPattern(int i,int n) {
        if(i > n) return;
        printRow(n-i," ");
        printRow(i," *");
        System.out.println();
        printPattern(i+1,n);

    }

    private static void printRow(int i,String str) {
        if(i == 0) return;
        System.out.print(str);
        printRow(i-1,str);
    }

    // pattern using 1 function..

    private static void printP(int row,int col,int n){
        if(row>n) return; // all row completed
        if(col>n){ // all star printed for row
            System.out.println(); //now print new line and start new col for new line...
            printP(row+1,1,n);
            return;
        }
        System.out.print(" *");
        printP(row,col+1,n);

    }
}