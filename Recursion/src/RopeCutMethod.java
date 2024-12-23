public class RopeCutMethod {
    public static void main(String[] args) {
        System.out.println(maxPieces(23,11,9,12));
    }
    private static int maxPieces(int n,int a ,int b, int c){
        if (n==0) return 0;
        if (n<0) return -1;
        int result = max(maxPieces(n-a,a,b,c),maxPieces(n-b,a,b,c),maxPieces(n-c,a,b,c));
        if (result==-1){
            return -1;
        }
        return result+1;
    }
    private static int max(int a , int b ,int c){
        if (a>=b && a>=c){
            return a;
        } else if (b>=a && b>=c) {
            return b;
        }
        else return c;
    }
}
