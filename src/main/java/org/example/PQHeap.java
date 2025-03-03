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
        value = other.value;
        priority = other.priority;
    }


    /** PQ Heap CreateClone method**/
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

        /** Assign the new player at the end of the heap. **/
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


        return null;
    };

    public void clear() {};

    public  int getSize() {
        return size;
    };

    public boolean isEmpty() {
        return size == 0;
    };


}
