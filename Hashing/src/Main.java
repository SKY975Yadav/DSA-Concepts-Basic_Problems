//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
class temp{
    int[] linearProbing(int hash_size, int arr[], int sizeOfArray)
    {
        //Your code here

        int cap = hash_size;
        int [] table  = new int[cap];
        int size = 0;
        Arrays.fill(table, -1);
        for (int i=0;i<sizeOfArray;i++){
            if(size == cap)
                break;
            if (insert(arr[i],cap,table))
                size++;
        }
        return table;
    }
    boolean insert(int key,int cap,int [] table){
        int i=hash(key,cap);
        while(table[i]!=-1 && table[i]!=-2 && table[i]!=key)
            i=(i+1)%cap;
        if(table[i]==key)
            return false;
        else{
            table[i]=key;
            return true;
        }
    }
    int hash(int key,int cap){
        return key%cap;
    }
}
public class Main {
    public static void main(String[] args) {
        int [] ar = {3,5,2,4};
        temp t = new temp();
        int [] temp1 = t.linearProbing(6,ar,ar.length);
        for (int e : temp1){
            System.out.print(e+" ");
        }
    }
}