/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taquin1;

import java.util.*;

public class DepthFirstSearch extends AbstractSearchEngine {
     @Override
    List<State> search(State initialState) {
        Stack<State> stack = new Stack<>();
        Set<State> explored = new HashSet<>();
        Map<State, State> cameFrom = new HashMap<>();
        stack.push(initialState);
        cameFrom.put(initialState, null);

        while (!stack.isEmpty()) {
            State current = stack.pop();

            if (current.isGoalState()) {
                return reconstructPath(cameFrom, current);
            }

            explored.add(current);

            for (State successor : current.generateSuccessors()) {
                if (!explored.contains(successor) && !stack.contains(successor)) {
                    stack.push(successor);
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
