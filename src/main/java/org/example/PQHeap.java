package org.example;

public class PQHeap implements PriorityQueue{

    private int value;
    private int priority;

    private Player[] heap;
    private int size;




   /** Default Constructor**/
    public PQHeap(int capacity) {
        heap = new Player[capacity];
        size = 0;
    }

    /** Deep Copy Constructor **/
    public PQHeap(PQHeap other) {
        this.heap = new Player[other.heap.length];
       this.size = other.size;

       /** This copies all the Player objects from the other.heap to this.heap **/
       for(int i = 0; i < this.heap.length; i++){
           this.heap[i] = new Player(other.heap[i]);
       }
    }


    /** PQ Heap CreateClone method: creates a deep copy of the current instance. **/
    public PQHeap createClone() {
        return new PQHeap(this);
    }

    /** this method gets the parent index **/
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    /** this method returns the left child's index. **/
    private int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    /** this method returns the right child's index. **/
    private int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }


    public void add(Player a) {

        /** if the heap is full,
         * create a new array
         * and copy the array's data over into the temp array
         **/
        if(size == heap.length) {
            Player [] temp = new Player[heap.length * 2];
            System.arraycopy(heap, 0, temp, 0, heap.length);
            heap = temp;
        }



        /** Add the new player to the heap **/
        heap[size] = a;



        int index = size - 1; // The newly inserted element
        while (index > 0 && heap[index].getScore() > heap[getParentIndex(index)].getScore()) {
            int parentIndex = getParentIndex(index);

            Player temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;

            // Move up the heap
            index = parentIndex;
        }
        size++;
    };

    public  Player getHighestScorePlayer() {
        if(size == 0 ) {
            return null;
        }



        Player topScore = heap[0];
        heap[0] = heap[size - 1]; // Move last element to root
        size --;

        int index = 0;

        if(size == 0) {
            return topScore;
        }

        while(true) {
            // Check if left child exists and has a greater score
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            int largest = index;

            /** this condition checks if the left child exists and has a greater score**/
            if (leftChildIndex < size && heap[leftChildIndex].getScore() > heap[largest].getScore()) {
                largest = leftChildIndex;
            }

            /** this condition checks if the right child exists and has a greater score than the current largest score**/
            if (rightChildIndex < size && heap[rightChildIndex].getScore() > heap[largest].getScore()) {
                largest = rightChildIndex;
            }

            // If no swaps are needed, heapify-down is complete
            if (largest == index) {
                break;
            }


            // Swap current index with the largest child
            Player temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;

            // Move index down to continue heapify-down
            index = largest;

        }
        return topScore;


    };

    public void clear() {
        size = 0;
    };

    public  int getSize() {
        return size;
    };

    public boolean isEmpty() {
        return size == 0;
    };


}
