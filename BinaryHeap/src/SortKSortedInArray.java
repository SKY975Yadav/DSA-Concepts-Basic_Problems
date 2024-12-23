import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedInArray {
    public static void main(String[] args) {
        int [] arr = {9,8,7,19,18};
        sortKSortInAnArray(arr,2);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortKSortInAnArray(int [] arr,int k){ // In array every ith element will be in the range from i-k  to i + k we have to sort this
        int n = arr.length;
        if (n==0 || k <=0) return;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            minHeap.add(arr[i]);
        }
        int ind = 0;
        for (int i = k+1; i < n; i++) {
            arr[ind++] = minHeap.remove();
            minHeap.add(arr[i]);
        }
        while (!minHeap.isEmpty()){
            arr[ind++] = minHeap.remove();
        }
    }
}
