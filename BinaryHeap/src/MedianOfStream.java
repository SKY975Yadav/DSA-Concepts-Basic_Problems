import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {
    public static void main(String[] args) {
        int [] arr = {25,7,10,15,20};
        System.out.println(medianOfStream(arr));
    }
    public static ArrayList<Double> medianOfStream(int [] arr){
        int n = arr.length;
        ArrayList<Double> res = new ArrayList<>();

        if (n == 0) return res;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int val : arr) {
            // Add to maxHeap first (maxHeap contains the smaller half of the numbers)
            if (maxHeap.isEmpty() || val <= maxHeap.peek()) {
                maxHeap.add(val);
            } else {
                minHeap.add(val);
            }

            // Balance the heaps if necessary
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            // Calculate the median
            if (maxHeap.size() == minHeap.size()) {
                res.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            } else {
                res.add((double) maxHeap.peek());
            }
        }
        return res;
    }
}
