public class HeapSort {
    private int left(int i) {
        return (2 * i + 1);
    }
    private int right(int i) {
        return (2 * i + 2);
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // Your code here
        for (int i = (n-2)/2; i >= 0; i--) {
            heapify(arr,n,i);
        }
    }

    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int ind)
    {
        // Your code here
        int largest = ind;
        int leftChild = left(ind);
        int rightChild = right(ind);

        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != ind) {
            swap(arr, ind, largest);
            heapify(arr, n, largest);
        }
    }

    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr,n);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }

    }
    private void swap(int [] arr,int i,int j){
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }

    public static void main(String[] args) {

    }
}
