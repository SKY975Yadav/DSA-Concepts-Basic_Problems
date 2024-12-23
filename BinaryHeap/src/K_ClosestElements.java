import java.util.Comparator;
import java.util.PriorityQueue;

public class K_ClosestElements {
    public static void main(String[] args) {
        int[] arr = {12, 8, 6, 15, 21, 10, 5, 13, 2, 21};
        kClosestElements(arr, 3, 5);

    }

    static class Pair {
        int diff, ind;

        Pair(int diff, int ind) {
            this.diff = diff;
            this.ind = ind;
        }
    }

    public static void kClosestElements(int[] arr, int k, int x) {
        if (k <= 0) return;
        Comparator<Pair> com = (first, second) -> second.diff - first.diff;
        PriorityQueue<Pair> pq = new PriorityQueue<>(com);

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(Math.abs(x - arr[i]), i));
        }
        for (int i = k; i < arr.length && !pq.isEmpty(); i++) {
            int diff = Math.abs(x - arr[i]);
            if (diff < pq.peek().diff) {
                pq.poll();
                pq.add(new Pair(diff, i));
            }
        }
        int size = pq.size();
        int[] temp = new int[size];
        for (int i = 0; i < size && !pq.isEmpty(); i++) {
            temp[i] = arr[pq.poll().ind];
        }
        for (int i = size-1; i >= 0; i--) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
    }
}
