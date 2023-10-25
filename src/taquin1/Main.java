/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taquin1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] initialBoard = {{2, 1, 3}, {8, 0, 4}, {7, 6, 5}}; // Initial state of the 8-puzzle
        State initialState = new State(initialBoard);
        
        AStarSearchEngine aStarSearchEngine = new AStarSearchEngine();
        EightPuzzle eightPuzzleAStar = new EightPuzzle(initialState, aStarSearchEngine);
        System.out.println("Solving with A* Search:");
        eightPuzzleAStar.solve();

        BreadthFirstSearch breadthFirstSearchEngine = new BreadthFirstSearch();
        EightPuzzle eightPuzzleBFS = new EightPuzzle(initialState, breadthFirstSearchEngine);
        System.out.println("\nSolving with Breadth-First Search:");
        eightPuzzleBFS.solve();

        DepthFirstSearch depthFirstSearchEngine = new DepthFirstSearch();
        EightPuzzle eightPuzzleDFS = new EightPuzzle(initialState, depthFirstSearchEngine);
        System.out.println("\nSolving with Depth-First Search:");
        eightPuzzleDFS.solve();
    }
}