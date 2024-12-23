//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Swap{
    public static void swapArray(int []a,int indX,int indY){
        int temp = a[indX];
        a[indX]= a[indY];
        a[indY]=temp;
    }
    public static void swapIntegers(IntWrapper x, IntWrapper y) {
        int temp = x.value;
        x.value = y.value;
        y.value = temp;
    }

    static class IntWrapper {
        int value;
        public IntWrapper(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }

        @Override
        public String toString() {
            return ""+ value; // Customize the string representation
        }
    }

}
public class Main {
    public static void main(String[] args) {
        Swap.IntWrapper sw1 = new Swap.IntWrapper(10);
        Swap.IntWrapper sw2 = new Swap.IntWrapper(20);
        int a = (sw1.getValue());
        System.out.println(sw1);
        Swap.swapIntegers(sw1,sw2);
        System.out.println(sw1.value+" "+sw2.value);

    }
}