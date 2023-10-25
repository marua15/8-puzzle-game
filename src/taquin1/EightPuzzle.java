/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taquin1;

import java.util.*;

public class EightPuzzle {
    private State initialState;
    private AbstractSearchEngine searchEngine;

    public EightPuzzle(State initialState, AbstractSearchEngine searchEngine) {
        this.initialState = initialState;
        this.searchEngine = searchEngine;
    }

    public void solve() {
        List<State> solutionPath = searchEngine.search(initialState);

        if (solutionPath != null) {
            System.out.println("Solution found. Steps to the solution:");
            for (State state : solutionPath) {
                state.print();
                System.out.println();
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}
