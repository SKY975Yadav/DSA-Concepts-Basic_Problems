import java.util.*;

class ImportantProblems{
    // Problem 1 Union of two sorted arrays TC = O(m+n) if m is big then it run for m time els for n time
    public void printOfUnionOfTwoSortedArrays(int[]a,int[]b){
        int m= a.length;
        int n= b.length;
        int i=0,j=0;
        while(i<m && j<n){
            if(i>0 && a[i-1]==a[i]){i++;continue;}
            if(j>0 && b[j-1]==b[j]){j++;continue;}
            if(a[i]<b[j]){System.out.print(a[i]+" ");i++;}
            else if(a[i]>b[j]){System.out.print(b[j]+" ");j++;}
            else{System.out.print(a[i]+" ");i++;j++;}
        }
        while(i<m){if(i==0||a[i]!=a[i-1])System.out.print(a[i]+" ");i++;}
        while(j<n){if(j==0||b[j]!=b[j-1])System.out.print(b[j]+" ");j++;}
    }
    // Problem 1 Intersection of two sorted arrays
    //Naive solution time complexity O(m*n)
//    public void printOfIntersectionOfTwoSortedArrays(int[]a,int[]b){
//        for (int i=0;i<a.length;i++){
//            if (i==0 || a[i]!=a[i-1]) {
//                for (int j = 0; j < b.length; j++) {
//                    if (j==0 || b[j]!=b[j-1]) {
//                        if (a[i] == b[j])
//                            System.out.println(a[i]);
//                    }
//                }
//            }
//        }
//    }
    //Optimal : O(m+n)using merge
    public void printOfIntersectionOfTwoSortedArrays(int[]a,int[]b){
        int m = a.length;
        int n = b.length;
        int i=0,j=0;
        while (i<m && j<n){
            if (i>0 && a[i]==a[i-1]){ i++; continue;}
            if (a[i]==b[j]){ System.out.println(a[i]); i++;j++;}
            else if (a[i]<b[j])i++;
            else j++;
        }
    }
    //Problem 3 MinimumDifference between elements in given array
    public int minimumDifferenceInArray(int []ar){
        Arrays.sort(ar);
        int n = Integer.MAX_VALUE;
        for (int i=1;i<ar.length;i++){
            if (ar[i]-ar[i-1]<n){
                n=ar[i]-ar[i-1];
            }
        }
        return n;
    }
    //Problem 4 sorting two types of elements
    public void sortingTwoTypesOfElementsOfPositiveAndNegative(int[]ar) {
        int i = -1;
        int j = ar.length;
        while (true) {
            do {
                i++;
            } while (ar[i] < 0);
            do {
                j--;
            } while (ar[j] > 0);
            if (i>=j) return;
            Swap.swapArray(ar,i,j);
        }
    }
    public void sortingTwoTypesOfElementsOfEvenAndOdd(int[]ar) {
        int i = -1;
        int j = ar.length;
        while (true) {
            do {
                i++;
            } while (ar[i] % 2 == 0);
            do {
                j--;
            } while (ar[j] % 2 != 0);
            if (i>=j) return;
            Swap.swapArray(ar,i,j);
        }
    }
    public void sortingTwoTypesOfElementsOfBinaryArray(int[]ar) {
        int i = -1;
        int j = ar.length;
        while (true) {
            do {
                i++;
            } while (i<ar.length && ar[i] == 0);
            do {
                j--;
            } while (j>=0 && ar[j] == 1);
            if (i>=j) return;
            Swap.swapArray(ar,i,j);
        }
    }
    //Problem 5 sorting three types of elements
    //My Solution 4 traversal
//    public void sortingThreeTypesOfElementsOf0s1s2s(int[]ar) {
//        int i = -1;
//        int j = ar.length;
//        while (true) {
//            do {i++;} while (ar[i] == 0);
//            do {j--;} while (ar[j] == 1 || ar[j]==2);
//            if (i>=j){
//                int low = j;
//                int high = ar.length;
//                do {low++;} while (ar[low] == 1);
//                do {high--;} while (ar[high] == 2 );
//                if (low>=high) return;
//                Swap.swapArray(ar,low,high);
//            }
//            if (i>=j) return;
//            Swap.swapArray(ar,i,j);
//        }
//    }
    //Best Solution : 1 Traversal
    /*
    Case 1 : given 0s1s2s it is  simple 1st == 0 else if == 1 else(i.e 2)
    Case 2 :If three types of elements are like in this way that is we given a pivot  we have sort the array as elements less
    than pivot first then all pivot elements then elements greater than elements have to sort
    ex:         [1,4,2,6,12,6,35,2,3,6,21], pivot = 6
    then ans = [1,3,2,4,2,6,6,6,12,35,21]
    in this case conditions are
     if ar[mid] < pivot,then swap(mid,low),l++,mid++ else if ar[mid] == pivot mid++; else swap(mid,high),high--;
    Case 3 : given a range(i,j) we have to sort the element in way that first all the elements lesser than i
    then between range of i and j then elements greater than j
     */
    public void sortingThreeTypesOfElements(int[]ar) {
        int low=0,mid=0,high=ar.length-1;
        while (mid<=high){
            if (ar[mid]==0){
                Swap.swapArray(ar,mid,low);
                low++;
                mid++;
            } else if (ar[mid]==1) {
                mid++;
            }
            else {
                Swap.swapArray(ar,mid,high);
                high--;
            }
        }
    }
    //kth smallest element
    //My Solution : O(n log n) + O(n) = O(n Log n)
    public static int kthSmallestElement(int []ar , int k){
        Arrays.sort(ar);
        if (k==1) return ar[0];
        int x = 1;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] == ar[i - 1]) {
                continue;
            }
            x++;
            if (x == k) {
                return ar[i];
            }
        }
        return Integer.MIN_VALUE;
    }
    public static int kthLargestElement(int[]ar,int k){
        Arrays.sort(ar);
        if (k==1) return ar[ar.length-1];
        int x = 1;
        for (int i = ar.length-2; i >=0; i--) {
            if (ar[i] == ar[i + 1 ]) {
                continue;
            }
            x++;
            if (x == k) {
                return ar[i];
            }
        }
        return Integer.MIN_VALUE;
    }
    public int kthSmallestElementUsingQuickSelect(int [] arr,int n,int k){
        int l = 0,r = n-1;
        while (l <= r) {
            int pivot = lomutoPartition(arr, l, r);
            if (pivot == k-1) return pivot; // we can return the value arr[pivot]
            if (pivot < k-1){
                l = pivot+1;
            }
            else r = pivot-1;
        }
        return -1;
    }
    public int lomutoPartition(int [] arr,int l,int r){
        int pivot = arr[r];
        int i = l-1;
        for (int j = l; j < r;j++){
            if (arr[j]<pivot){    // change <   to   > if we want Kth largest
                i++;
                Swap.swapArray(arr,i,j);
            }
        }
        Swap.swapArray(arr,i+1,r);
        return i+1;
    }


    /*
    Problem 7 :
        This video discusses the problem of taking an unsorted array and counting the inversions in it. There are two conditions for the  elements to be inverse:
        arr[i] > arr[j]
        i <j
     */
    public int countInversion(int [] arr,int l,int r){ //TC : O(n log n)
        int res = 0;
        if(l<r){
            int mid = (l+r)/2;
            res += countInversion(arr,l,mid);
            res += countInversion(arr,mid+1,r);
            res += countInvAndMerge(arr,l,mid,r);
        }
        return res;
    }
    private int countInvAndMerge(int [] arr, int l,int m,int r){
        int n1 = m - l + 1,n2 = r - m;
        int [] left = new int[n1];
        int [] right = new int[n2];
        System.arraycopy(arr, l , left, 0, n1);
        System.arraycopy(arr, m+1 , right, 0, n2);
        int res = 0,i=0,j=0,k=l;
        while (i<n1 && j<n2){
            if (left[i]<=right[j]){
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
                res += n1-i;
            }
        }
        while(i<n1)
            arr[k++]=left[i++];
        while(j<n2)
            arr[k++]=right[j++];
        return res;
    }


    //Problem 8 merge overlapping  TC : O(n log n)

    static class Pair{
        int start;
        int end;
        Pair(int start , int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "{"+this.start+", "+this.end+"}";
        }

        public boolean equals(Pair obj) {
            return this.start == obj.start && this.end == obj.end;
        }
    }
    public ArrayList<Pair> mergeOverlapOfIntervals(Pair [] inp){ // It modify original array if we want our array to not change , then created an temp array and copy them

        Pair [] arr = Arrays.copyOf(inp,inp.length);  // just to not modify the original array, don't need if we you can modify the original array

        ArrayList<Pair> resPairs = new ArrayList<>();


        Comparator<Pair> cmp = Comparator.comparingInt(o -> o.start);
        Arrays.sort(arr,cmp);
        int res = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[res].end >= arr[i].start){
                arr[res].start = Math.min(arr[res].start,arr[i].start);
                arr[res].end = Math.max(arr[res].end,arr[i].end);
            }
            else {
                resPairs.add(arr[res]);
                res++;
                arr[res] = arr[i];
            }
        }
        resPairs.add(arr[res]);
        return resPairs;
    }


    //Problem 9 meeting max guests TC : O(n log n)
    public int maxGuest(int[] arr, int[] dep, int n) // Meeting max guests given two two arrays one array contains tine of when they come to party and another array when they leave the party, Idea is simple sort the both arrays and check at a moment how many guests there, Note time 10:20 like we write as 1030
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1, j = 0, res = 1, curr = 1;
        while (i < n && j < n) {
            if (arr[i] < dep[j]) {
                curr++;
                i++;
            } else {
                res = Math.max(curr, res);
                curr--;
                j++;
            }
        }
        return res;
    }
}
public class Problems {
    public static void main(String[] args) {
        ImportantProblems ip = new ImportantProblems();
        //Problem 1 & 2 :
//        int [] a = {3,3,6,6,8,8,31,34,35,343,343};
//        int [] b =  {3,3,6,12,23,23,42,42,343};
//        ip.printOfUnionOfTwoSortedArrays(a,b);
//        ip.printOfIntersectionOfTwoSortedArrays(a,b);

        //Problem 3
//        int [] c = {41,13,2,63,73,75};
//        System.out.println(ip.minimumDifferenceInArray(c));

        //Problem 4
//        int [] d = {-12,23,-2,5,-3};
//        int [] e = {1,4,2,6,12,6,35,2,3,6,21,9};
//        int []f = {0};
//        for (int num : f){System.out.print(num+" ");}
//        System.out.println();
//        ip.sortingTwoTypesOfElementsOfPositiveAndNegative(d);
//        ip.sortingTwoTypesOfElementsOfEvenAndOdd(e);
//        ip.sortingTwoTypesOfElementsOfBinaryArray(f);
//        for (int num : f){System.out.print(num+" ");}
//        System.out.println();

        //Problem 5

//       int [] g = {0,2,0,1,2,0,1,0,1,2,2,0};
//        int [] h = {2,4,12,4,3,31,34,52,12,75};
//        for (int num : g){System.out.print(num+" ");}
//        System.out.println();
//        ip.sortingThreeTypesOfElements(g);
//        ip.sortingThreeTypesOfElements(h,12);
//        ip.sortingThreeTypesOfElements(h,3,12);
//        for (int num : g){System.out.print(num+" ");}
//        System.out.println();

        //Problem 6
//        int [] i = {2,6,54,52,46,53,12};
//        for (int num :i){System.out.print(num+" ");}
//        System.out.println();
//        System.out.println(ip.kthSmallestElement(i,1));
//        System.out.println(ip.kthLargestElement(i,1));
//        int ind = ip.kthSmallestElementUsingQuickSelect(i,i.length,5);
//        System.out.println(Arrays.toString(i));
//        System.out.println(i[ind]);


        //Problem 7
//        int [] arr = {2,13,6,1,4,7,8};
//        int res = ip.countInversion(arr,0, arr.length-1);
//        System.out.println(res);


        //Problem 8
//        ImportantProblems.Pair[] al = {new ImportantProblems.Pair(5,10),
//        new ImportantProblems.Pair(3,15),
//        new ImportantProblems.Pair(18,30),
//        new ImportantProblems.Pair(2,7)};
//
//        System.out.println(ip.mergeOverlapOfIntervals(al));

        //Problem 9
        int [] arr  = {500,1100,800,400};
        int [] des = {600,1200,900,700};

        System.out.println(ip.maxGuest(arr,des, arr.length));
    }
}
