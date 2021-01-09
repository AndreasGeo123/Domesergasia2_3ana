import java.util.Comparator;

public class HeapPriorityQueue <City> implements PriorityQueueInterface <City> {



    private City[] heap; // the heap to store data in
    private int size; // current size of the queue
    private Comparator <City> comparator; // the comparator to use between the objects

    private static final int DEFAULT_CAPACITY = 4; // default capacity
    private static final int AUTOGROW_SIZE = 4; // default auto grow


    public HeapPriorityQueue(Comparator<City> comparator) {
        this.heap = (City[]) new Object[DEFAULT_CAPACITY + 1];
        this.size = 0;
        this.comparator = comparator;
    }


    @Override
    public void add(City item) {
        // Check available space
        if (size == heap.length - 1)
            grow();

        // Place item at the next available position
        heap[++size] = item;

        // Let the newly added item swim
        swim(size);
    }

    @Override
    public boolean isEmpty(){

        return heap[1] == null;
    }

    @Override
    public int size() {

        return size;
    }

    /*@Override
    public City remove(City id){
        City temp =heap[0];
        for (int i =0; i <=size; i++){

        }
        return null;
    }*/


    @Override
    public City peek() {
        // Ensure not empty
        if (size == 0)
            return null;

        // return root without removing
        return heap[1];
    }


    @Override
    public City getMax() {
        // Ensure not empty
        if (size == 0)
            return null;

        // Keep a reference to the root item
        City root = heap[1];

        // Replace root item with the one at rightmost leaf
        heap[1] = heap[size];
        size--;

        // Dispose the rightmost leaf
        // Sink the new root element
        sink(1);

        // Return the int removed
        return root;
    }


    private void swim(int i) {
        // if i is root (i==1) return
        if (i == 1)
            return;

        // find parent
        int parent = i / 2;

        // compare parent with child i
        while (i != 1 && comparator.compare(heap[i], heap[parent]) > 0) {
            swap(i, parent);
            i = parent;
            parent = i / 2;
        }

        // recursive function
        // if (heap[i] > heap[parent]) {
        //     swap(i, parent);
        //     swim(parent);
        // }
    }


    private void sink(int i) {
        // determine left, right child
        int left = 2 * i;
        int right = left + 1;

        // if 2*i > size, node i is a leaf return
        if (left > size)
            return;

        // while haven't reached the leafs
        while (left <= size) {
            // Determine the largest child of node i
            int max = left;
            if (right <= size) {
                if (comparator.compare(heap[left], heap[right]) < 0)
                    max = right;
            }

            // If the heap condition holds, stop. Else swap and go on.
            // child smaller than parent
            if (comparator.compare(heap[i], heap[max]) >= 0)
                return;
            else {
                swap(i, max);
                i = max;
                left = i * 2;
                right = left + 1;
            }
        }
    }


    private void swap(int i, int j) {
        City tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    /**
     * Helper function to grow the size of the heap
     */
    private void grow() {
        City[] newHeap = (City[]) new Object[heap.length + AUTOGROW_SIZE];

        // copy array
        System.arraycopy(heap, 1, newHeap, 1, size);

        heap = newHeap;
    }
}