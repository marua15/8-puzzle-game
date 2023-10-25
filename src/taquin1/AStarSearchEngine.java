/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taquin1;

import java.util.*;

public class AStarSearchEngine extends AbstractSearchEngine {
    @Override
    List<State> search(State initialState) {
        PriorityQueue<State> openSet = new PriorityQueue<>(Comparator.comparingInt(s -> s.getCost() + s.getDepth()));
        Set<State> closedSet = new HashSet<>();
        Map<State, State> cameFrom = new HashMap<>();
        openSet.add(initialState);
        cameFrom.put(initialState, null);

        while (!openSet.isEmpty()) {
            State current = openSet.poll();

            if (current.isGoalState()) {
                return reconstructPath(cameFrom, current);
            }

            closedSet.add(current);

            for (State successor : current.generateSuccessors()) {
                if (closedSet.contains(successor)) {
                    continue;
                }

                int newCost = current.getCost() + 1;
                if (!openSet.contains(successor) || newCost < successor.getCost()) {
                    successor.cost = newCost;
                    successor.depth = current.getDepth() + 1;
                    openSet.add(successor);
                    cameFrom.put(successor, current);
                }
            }
        }

        return null;
    }

    private List<State> reconstructPath(Map<State, State> cameFrom, State current) {
        List<State> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = cameFrom.get(current);
        }
        Collections.reverse(path);
        return path;
    }
}