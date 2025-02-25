package org.example;

public class PQHeap implements PriorityQueue{

    private int value;
    private int priority;

    private int[] heap;
    private int size;



   /** Default Constructor**/
    public PQHeap(int capacity) {
        heap = new int[capacity];
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



    public void add(Player a) {

    };

    public  Player getHighestScorePlayer() {};

    public void clear() {};

    public  int getSize() {};

    public boolean isEmpty() {};


}
