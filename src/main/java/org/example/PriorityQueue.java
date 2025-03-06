package org.example;

/**
 * The PriorityQueue interface shows the operations for a priority queue data structure.
 * A priority queue allows elements to be added, retrieved, and removed based on priority.
 */

public interface PriorityQueue {

    /**
     * Adds a player to the priority queue.
     *
     * @param a The Player object to be added to the queue.
     */
    public void add(Player a);

    /**
     * Gets and removes the player with the highest score from the priority queue.
     *
     * @return The Player object with the highest score, or null if the queue is empty.
     */
    public  Player getHighestScorePlayer();

    /**
     * Clears the priority queue by removing all elements.
     */
    public void clear();

    /**
     * Returns the number of elements in the priority queue.
     *
     * @return The current size of the priority queue.
     */
    public  int getSize();

    /**
     * Checks if the priority queue is empty.
     *
     * @return true if the priority queue is empty, false otherwise.
     */
    public boolean isEmpty();


}