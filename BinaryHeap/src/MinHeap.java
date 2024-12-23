import java.util.Arrays;

public class MinHeap {
    private final int[] arr;
    private int size;
    private final int cap;
    MinHeap(int cap) {
        arr = new int[cap];
        size = 0;
        this.cap = cap;
    }
    private int left(int i) {
        return (2 * i + 1);
    }
    private int right(int i) {
        return (2 * i + 2);
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    public void insert(int x) throws Exception {
        if (size > cap) throw new Exception("Min Heap overflow");
        arr[size++] = x;
        for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i];) {
            swap(i,parent(i));
            i = parent(i);
        }
    }
    public int peek() {
        return arr[size - 1];
    }
    public void minHeapify(int ind) {
        int smallest = ind;
        while (true){
            if (left(ind) < size &&arr[left(ind)] < arr[ind]) {
                smallest = left(ind);
            }
            if (right(ind) < size && arr[right(ind)] < arr[smallest]){
                smallest = right(ind);
            }
            if (ind == smallest) break;
            swap(ind,smallest);
            ind = smallest;
        }
    }
    public void minHeapify(int [] arr,int ind,int size) { // For build Heap function
        int smallest = ind;
        while (true){
            if (left(ind) < size &&arr[left(ind)] < arr[ind]) {
                smallest = left(ind);
            }
            if (right(ind) < size && arr[right(ind)] < arr[smallest]){
                smallest = right(ind);
            }
            if (ind == smallest) break;
            swap(arr,ind,smallest);
            ind = smallest;
        }

    }
    public int extractMin(){
        if (size <= 0) return Integer.MIN_VALUE;
        if (size == 1) {
            size--;
            return arr[0];
        }
        int res = arr[0];
        swap(0,size-1);
        size--;
        minHeapify(0);
        return res;
    }
    public void replace(int i,int data){ // decrease key
        arr[i] = data;
        while (i != 0 && arr[parent(i)] > arr[i]){
            swap(i,parent(i));
            i = parent(i);
        }
    }
    public void delete(int i){
        replace(i,Integer.MIN_VALUE);
        extractMin();
    }
    public void buildHeap(int [] arr){
        int n = arr.length;
        for (int i = (n-2)/2; i >= 0; i--) {
            minHeapify(arr,i,n);
        }
    }
    private void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] temp = {5,3,12,75,12,7,11,15};
        MinHeap mh = new MinHeap(10);
        System.out.println(Arrays.toString(temp));
    }

}
