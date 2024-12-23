public class Main {
    public static void main(String[] args) {
//        System.out.println(sumOfProductOfDigits(15,14));
//        System.out.println(sumOfMaxAndMin(new int[]{3,6,34,73,5},5));
        System.out.println(longestLength(new int[]{1,1,1,4,4,4,4,4,4,2},10));
    }
    public static int longestLength(int a[], int n)
    {
        // your code here
        if (n == 0) {
            return 0; // Handle empty array case
        }
        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        // Check the last sequence
        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }
    public static int sumOfProductOfDigits(int n1, int n2)
    {
        //  your code here
        if(n1==0 || n2 == 0){
            return 0;
        }
        int sum = n1%10 * n2%10;
        return sum + sumOfProductOfDigits(n1/10,n2/10);
    }
    public static int sumOfMaxAndMin(int a[], int n)
    {
        // your code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]<min){
                min = a[i];
            }
        }
        for(int i=0;i<n;i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        return min+max;
    }
}
