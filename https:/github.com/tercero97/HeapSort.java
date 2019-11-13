public class HeapSort
{

    int[] heap;
    int size;
    int lastPosition;

    public HeapSort(int[] array) {
        heap = array;
        this.size = array.length;
        lastPosition = array.length - 1;
    }

    // Return the maximum element in the heap
    public int findMax() {
        if(size > 0) {
            return heap[0];
        } else {
            return -1;
        }
    }

    // Find the maximum element the heap and delete it O(logn)
    public int extractMax() {
        int max = heap[0];
        delete(0);
        return max;
    }

    // Insert a new element into the heap O(logn)
    public void insert(int x) {
        heap[lastPosition] = x;
        siftUp(heap, lastPosition);
        lastPosition++;
    }

    // Delete element at location i O(logn)
    public void delete(int i) {
        heap[i] = heap[lastPosition];
        lastPosition--;
        size--;
        // One of these will do nothing.
        siftUp(heap, i);
        siftDown(heap, i);
    }

    // move item at location i up to its correct position O(logn)
    public void siftUp(int[] h, int i) {
        int parent = (int)Math.floor((i-1)/2);
        if(i > 0 && h[parent] < h[i]) {
            int temp = h[i];
            h[i] = h[parent];
            h[parent] = temp;
            siftUp(h, parent);
        }
    }

    // move item at location i down to its correct position O(logn)
    public void siftDown(int[] h, int i) {
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;
        int largerChild;
        if(rightChild < size && h[rightChild] > h[leftChild]) {
            largerChild = rightChild;
        } else {
            largerChild = leftChild;
        }
        if(largerChild < size && h[largerChild] > h[i]) {
            int temp = h[i];
            h[i] = h[largerChild];
            h[largerChild] = temp;
            siftDown(h, largerChild);
        }

    }

    // Create a heap from unsorted array (n is size of array)
    // You're only running siftDown on half of the array,
    // so it actually runs in O(n) rather than regular insertion
    // which would run in O(nlogn)
    public void heapify(int[] h) {
        for(int i = (int)Math.floor((size-1)/2); i >= 0; i--) {
            siftDown(h,i);
        }
    }

    // returns a sorted array, using in-place heapsort
    // O(nlogn)
    public int[] heapSort() {
        heapify(heap);
        for(int i = size - 1; i >= 1; i--) {
            int max = extractMax();
            heap[i] = max;
        }
        return heap;
    }

    public void print() {
        System.out.println("Printing heap //////");
        for(int i = 0; i < heap.length; i++){
            System.out.println(heap[i]);
        }
    }

    public static void main(String[] args) {
        long inicioTiempo= System.nanoTime();
        int[] vector10 = {36, 31, 20, 40, 23, 18, 15, 79, 27, 83};
        int[] vector20 = {20,50,65,32,4,5,6,79,100,321,8654,6545,6454,642221,645479,978,9754,97978,42216,23};
        int[] vector200 = {646,5,23,3,1,6,4,9,664,64,231,315,97,89,978,954,547,985,654,512,32156,646,8984,9854,9521,648,9849,97942,9485599,549549
                ,9499,9495459,95421,94549,545942,36464,979789,74546,4945,6452,89792,16168,94549,84945,894954,95453,123138919,19192,9498,664549,949,799,451,100,62,6216,85,74,93,
                126,616,612,3221,332,654,898,9221,232,313,3164,64613,642,645,46,585,2564,89,64,621,3587,651,5,4,3,2,1,6564,94,79,754,21,32,65,46,85,98,54,12,32,65,98,78,21
                ,21,1231,313,32156,646,8984,9854,9521,648,9849,97942,9485599,549549,9499,9495459,95421,94549,545942,36464,979789,74546,4945,6452,89792,16168,94549,84945,894954,95453,123138919,19192,9498,664549,949,799,451,100,62,6216,85,74,93, 126,616,612,3221,332,654,898,9221,232,313,3164,64613,642,645,46,585,2564,89,64,621,3587,651,5,4,3,2,1,6564,94,79,754,21,32,65,46,85,98,54,12,32,65,98,78,21,21,1231,313,131,64,47,97,945,62,31,646};
        int[] vector400 = {646,5,23,3,1,6,4,9,664,64,231,315,97,89,978,954,547,985,654,512,32156,646,8984,9854,9521,648,9849,97942,9485599,549549
                ,9499,9495459,95421,94549,545942,36464,979789,74546,4945,6452,89792,16168,94549,84945,894954,95453,123138919,19192,9498,664549,949,799,451,100,62,6216,85,74,93,
                126,616,612,3221,332,654,898,9221,232,313,3164,64613,642,645,46,585,2564,89,64,621,3587,651,5,4,3,2,1,6564,94,79,754,21,32,65,46,85,98,54,12,32,65,98,78,21
                ,21,1231,313,131,64,47,97,945,62,31,646,646,5,23,3,1,6,4,9,664,64,231,315,97,89,978,954,547,985,654,512,32156,646,8984,9854,9521,648,9849,97942,9485599,549549,9499,9495459,95421,94549,545942,36464,979789,74546,4945,6452,89792,16168,94549,84945,894954,95453,123138919,19192,9498,664549,949,799,451,100,62,6216,85,74,93, 126,616,612,3221,332,654,898,9221,232,313,3164,64613,642,645,46,585,2564,89,64,621,3587,651,5,4,3,2,1,6564,94,79,754,21,32,65,46,85,98,54,12,32,65,98,78,21,21,1231,313,131,64,47,97,945,62,31,646,
                646,5,23,3,1,6,4,9,664,64,231,315,97,89,978,954,547,985,654,512,32156,646,8984,9854,9521,648,9849,97942,9485599,549549
                ,9499,9495459,95421,94549,545942,36464,979789,74546,4945,6452,89792,16168,94549,84945,894954,95453,123138919,19192,9498,664549,949,799,451,100,62,6216,85,74,93,
                126,616,612,3221,332,654,898,9221,232,313,3164,64613,642,645,46,585,2564,89,64,621,3587,651,5,4,3,2,1,6564,94,79,754,21,32,65,46,85,98,54,12,32,65,98,78,21
                ,95453,123138919,19192,9498,664549,949,799,451,100,62,6216,85,74,93, 126,616,612,3221,332,654,898,9221,232,313,3164,64613,642,645,46,585,2564,89,64,621,3587,651,5,4,3,2,1,6564,94,79,754,21,32,65,46,85,98,54,12,32,65,98,78,21,21,1231,313,131,64,47,97,945,62,31,646};

        HeapSort heapy = new HeapSort(vector10);
        int[] result = heapy.heapSort();
        System.out.println("printing result /////");
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
        long tiempofinal=System.nanoTime()-inicioTiempo;
        System.out.println("tiempo en nano segundos Usando HeapSort:"+tiempofinal);
    }
}

