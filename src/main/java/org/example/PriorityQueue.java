package org.example;

public interface PriorityQueue {

    public void add(Player a);

    public  Player getHighestScorePlayer();

    public void clear();

    public  int getSize();

    public boolean isEmpty();


}