public class BuildHeap {

    // this is a min heapify method
    static void heapify(int arr[], int n, int index){
        int i = index + 1;
        int largest = index;
        int leftChild = 2 * i - 1;
        int rightChild = 2 * i;

        if(leftChild < n && arr[leftChild] < arr[largest]){
            largest = leftChild;
        }
        if (rightChild < n && arr[rightChild] < arr[largest])
            largest = rightChild;

        if (largest != index) {
            int swap = arr[index];
            arr[index] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // take a heap, make it into an array, then heapify it
    static void buildHeap(int arr[], int n)
    {
      
        int startIdx = (n / 2) - 1;

      
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }
    // insert node at the end, recursively heapify
    static void insertNode(int arr[], int n, int Key)
    {
       
        n = n + 1;

        
        arr[n - 1] = Key;

        heapify(arr, n, n - 1);
    }
    // recursively move our data around so that the heap is in descending order
    static void minHeapSort(int[] arr, int n){
        if(n == 1){
            return;
        }

        int root = arr[0];

        arr[0] = arr[n-1];

        heapify(arr, n-1, 0);

        arr[n-1] = root;
        minHeapSort(arr, n-1);


    }

}

