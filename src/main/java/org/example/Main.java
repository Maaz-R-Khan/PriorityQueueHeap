package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * The Main class reads player data from a file, stores them in a heap, and sorts them using heapsort.
 */
public class Main {
    /**
     * The main method reads player data from "players.txt", stores them in a PQHeap,
     * and sorts them using heapsort.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Player p[];
        int playerCount = 0;

        try {
            //  Read the file to count the number of players
            Scanner infile = new Scanner(new FileReader("players.txt"));

            while (infile.hasNextLine()) {
                infile.nextLine(); // Read name
                if (infile.hasNextLine()) {
                    infile.nextLine(); // Read score
                    playerCount++;
                }
            }
            infile.close();

            //   Create Player array after counting
            p = new Player[playerCount];
            PQHeap heap = new PQHeap(playerCount);

            // Read players into array & add to heap
            infile = new Scanner(new FileReader("players.txt"));
            int index = 0;

            while (infile.hasNextLine()) {
                String name = infile.nextLine();
                if (!infile.hasNextLine()) break;

                int score = Integer.parseInt(infile.nextLine());
                p[index] = new Player(name, score); // Store in array
                heap.add(p[index]); // Add to heap
                index++;
            }
            infile.close();

            // Print original players
            System.out.println("Original Players:");
            for (Player player : p) {
                System.out.println(player.getName() + " - " + player.getScore());
            }


            heapsort(p);

            // Print the sorted players
            System.out.println("\nSorted Players:");
            for (Player player : p) {
                System.out.println(player.getName() + " - " + player.getScore());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + e);
        }
    }

    /**
     * Sorts an array of players using a priority queue heap.
     *
     * @param pa The array of Player objects to be sorted.
     */
    public static void heapsort(Player[] pa) {
        PQHeap heap = new PQHeap(pa.length);

        //add each player object to the heap.
        for (Player player : pa) {
            heap.add(player);
        }


        for (int i = 0; i < pa.length; i++) {
            pa[i] = heap.getHighestScorePlayer();
        }
    }
}
