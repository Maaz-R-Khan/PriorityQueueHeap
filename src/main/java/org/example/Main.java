package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player p[];
        int playerCount = 0;

        try {
            // Step 1: Read the file to count the number of players
            Scanner infile = new Scanner(new FileReader("players.txt"));

            while (infile.hasNextLine()) {
                infile.nextLine(); // Read name
                if (infile.hasNextLine()) {
                    infile.nextLine(); // Read score
                    playerCount++;
                }
            }
            infile.close();

            // Step 2: Create Player array after counting
            p = new Player[playerCount];
            PQHeap heap = new PQHeap(playerCount);

            // Step 3: Read players into array & add to heap
            infile = new Scanner(new FileReader("players.txt"));
            int index = 0;

            while (infile.hasNextLine()) {
                String name = infile.nextLine();
                if (!infile.hasNextLine()) break; // Avoid error if score is missing

                int score = Integer.parseInt(infile.nextLine());
                p[index] = new Player(name, score); // Store in array
                heap.add(p[index]); // Add to heap
                index++;
            }
            infile.close();

            // Step 4: Print original players
            System.out.println("Original Players:");
            for (Player player : p) {
                System.out.println(player.getName() + " - " + player.getScore());
            }

            // Step 5: Sort using heapsort
            heapsort(p);

            // Step 6: Print sorted players
            System.out.println("\nSorted Players:");
            for (Player player : p) {
                System.out.println(player.getName() + " - " + player.getScore());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + e);
        }
    }

    public static void heapsort(Player[] pa) {
        PQHeap heap = new PQHeap(pa.length);


        for (Player player : pa) {
            heap.add(player);
        }


        for (int i = 0; i < pa.length; i++) {
            pa[i] = heap.getHighestScorePlayer();
        }
    }
}
