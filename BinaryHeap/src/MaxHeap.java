public class MaxHeap {
    final int [] arr;
    int size;
    final int cap;
    MaxHeap(int cap){
        arr = new int[cap];
        size=0;
        this.cap = cap;
    }
    int left(int i) {return (2*i+1);}
    int right(int i) {return (2*i+2);}
    int parent(int i) { return (i-1)/2;}
    void insert(int x){
        arr[size++] = x;
        for(int i=size-1;i!=0 && arr[parent(i)]<arr[i];){
            int s = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)]= s;
            i = parent(i);
        }
    }
    int peek(){
        return arr[size-1];
    }
    public void maxHeapify(int ind) {
        int smallest = ind;
        while (true){
            if (left(ind) < size &&arr[left(ind)] > arr[ind]) {
                smallest = left(ind);
            }
            if (right(ind) < size && arr[right(ind)] > arr[smallest]){
                smallest = right(ind);
            }
            if (ind == smallest) break;
            swap(ind,smallest);
            ind = smallest;
        }

    }
    public void maxHeapify(int [] arr,int ind,int size) { // For build Heap function
        int smallest = ind;
        while (true){
            if (left(ind) < size &&arr[left(ind)] > arr[ind]) {
                smallest = left(ind);
            }
            if (right(ind) < size && arr[right(ind)] > arr[smallest]){
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
        swap(arr,0,size-1);
        size--;
        maxHeapify(0);
        return res;
    }
    public void replace(int i,int data){ // decrease key
        arr[i] = data;
        while (i != 0 && arr[parent(i)] < arr[i]){
            swap(arr,i,parent(i));
            i = parent(i);
        }
    }
    public void delete(int i){
        replace(i,Integer.MAX_VALUE);
        extractMin();
    }
    public void buildHeap(int [] arr){
        int n = arr.length;
        for (int i = (n-2)/2; i >= 0; i--) {
            maxHeapify(arr,i,n);
        }
    }
    private void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void swap(int [] arr ,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void display(){
        for (int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
