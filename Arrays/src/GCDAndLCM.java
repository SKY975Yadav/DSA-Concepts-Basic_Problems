import java.util.Scanner;

public class GCDAndLCM {
    public static void main(String[] args) {
//        System.out.println(LCM(10,5));
        Scanner sc = new Scanner(System.in);
        System.out.println(calculateGCD(45,120));

    }
    public static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calculateGCD(b, a % b);
        }
    }
    private static int GCD(int n,int m){

        int min = Math.min(n,m);
        for (int i=min;i>0;i--){
            if (m%i==0 && n%i==0){
                return i;
            }
        }
        return -1;
    }
    private static int LCM(int n,int m){
        int max = Math.max(n,m);
        int mul = n*m;
        for (int i=max;i<mul;i++){
            if (i%m==0 && i%n==0){
                return i;
            }
        }
        return -1;
    }

}
