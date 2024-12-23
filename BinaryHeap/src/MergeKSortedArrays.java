import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        int [] [] arr = {
                {1,4,7},
                {3,7,9},
                {2,5,8}
        };
        System.out.println(mergeKSortArrays(arr));
    }
    static class Triplet{
        int data,ArPos,ind;
        public Triplet(int data, int arPos, int ind) {
            this.data = data;
            ArPos = arPos;
            this.ind= ind;
        }
    }
    public static ArrayList<Integer> mergeKSortArrays(int [][] arr){
        int k = arr.length;
        if (k==0) return new ArrayList<>();

        Comparator<Triplet> cmp = Comparator.comparingInt(x -> x.data);
        PriorityQueue<Triplet> minHeap = new PriorityQueue<>(cmp);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (arr[i].length > 0) { // Ensure the array is not empty
                minHeap.add(new Triplet(arr[i][0], i, 0));
            }
        }

        while (!minHeap.isEmpty()){
            Triplet triplet = minHeap.poll();
            int data = triplet.data,pos = triplet.ArPos ,ind = triplet.ind;
            res.add(data);

            // Add next element from the same array to the heap
            if (ind < arr[pos].length-1){
                minHeap.add(new Triplet(arr[pos][ind+1],pos,ind+1));
            }
        }
        return res;
    }
}
