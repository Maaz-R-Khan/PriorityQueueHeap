package org.example;

/**
 * PQHeap implements a priority queue using a max-heap structure.
 * The heap stores Player objects based on their scores.
 */
public class PQHeap implements PriorityQueue{

    private int value;
    private int priority;

    private Player[] heap;
    private int size;

    /**
     * Default Constructor
     * Constructs a PQHeap with a specified capacity.
     *
     * @param capacity The maximum number of elements the heap can hold.
     */
    public PQHeap(int capacity) {
        heap = new Player[capacity];
        size = 0;
    }

    /**
     * Copy constructor: Creates a deep copy of another PQHeap instance.
     *
     * @param other The PQHeap object to be copied.
     */
    public PQHeap(PQHeap other) {
        this.heap = new Player[other.heap.length];
       this.size = other.size;

       // This copies all the Player objects from the other.heap to this.heap
       for(int i = 0; i < this.heap.length; i++){
           this.heap[i] = new Player(other.heap[i]);
       }
    }


    /**
     * Creates a deep copy of the current PQHeap instance.
     *
     * @return A new PQHeap object that is an identical copy of this one.
     */
    public PQHeap createClone() {
        return new PQHeap(this);
    }

    /**
     * Returns the index of the parent node for a given index.
     */
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    /**
     * Returns the index of the left child node for a given index.
     */
    private int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    /**
     * Returns the index of the right child node for a given index.
     */
    private int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    /**
     * Swaps two elements in the heap at the given indices.
     *
     * @param index1 The index of the first element.
     * @param index2 The index of the second element.
     */
    private void swap(int index1, int index2) {
        Player temp = heap[index1];
       heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    /**
     * Moves an element up the heap to maintain the max-heap property.
     */
    private void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);
        while (index > 0 && heap[index].getScore() > heap[parentIndex].getScore()) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    /**
     * Moves an element down the heap to maintain the max-heap property.
      */
    private void heapifyDown(int index) {
        while(true) {
            // Check if left child exists and has a greater score
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            int largest = index;

            // this condition checks if the left child exists and has a greater score
            if (leftChildIndex < size && heap[leftChildIndex].getScore() > heap[largest].getScore()) {
                largest = leftChildIndex;
            }

            //  this condition checks if the right child exists and has a greater score than the current largest score
            if (rightChildIndex < size && heap[rightChildIndex].getScore() > heap[largest].getScore()) {
                largest = rightChildIndex;
            }

            // If no swaps are needed, heapify-down is complete
            if (largest == index) {
                break;
            }

            swap(index, largest);


            // Move index down to continue heapify-down
            index = largest;
        }
    }

    /**
     * Adds the player to the heap
     */
    public void add(Player a) {
        heap[size] = a;
        heapifyUp(size);
        size++;
    }

/**
 * Removes and returns the player with the highest score
  */
    public Player getHighestScorePlayer() {
        if(size == 0) {
            return null;
        }

        Player topScore = heap[0]; // Store highest-scoring player
        heap[0] = heap[size - 1]; // Move last element to root
        size--;

        if(size > 0) { // this would prevent unnecessary heapifyDown when heap is empty
            heapifyDown(0);
        }
        return topScore;
    }

    /**
     * CLears the heap by resetting the size to zero.
     */
    public void clear() {
        size = 0;
    };

    /**
     * Returns the number of elements in the heap.
     */
    public  int getSize() {
        return size;
    };

    /**
     * Checks if the heap is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    };


}
