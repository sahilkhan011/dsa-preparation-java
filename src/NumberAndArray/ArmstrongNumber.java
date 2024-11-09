package NumberAndArray;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int number = 153;
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }

    private static boolean isArmstrong(int num) {
        int pow = String.valueOf(num).length();
        int sum = 0;
        int n = num;
        while(n>0){
            int ld = n % 10;
            sum += (int) Math.pow(ld, pow);
            n = n / 10;
        }
        return num == sum;
    }
}
