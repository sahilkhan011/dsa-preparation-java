package string;

public class LargestOddNumberProblem {
    public static void main(String[] args) {
        String res = largestOddNumber("4568954");
        System.out.println(res);
    }
    public static String largestOddNumber(String num) {
        for(int i = num.length()-1; i >= 0; i--){
            if( num.charAt(i)%2 != 0){
                return  num.substring(0,i+1);
            }
        }
        return "";
    }
}
