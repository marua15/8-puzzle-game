/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taquin1;

import java.util.*;

public class BreadthFirstSearch extends AbstractSearchEngine {
    @Override
    List<State> search(State initialState) {
        Queue<List<State>> queue = new LinkedList<>();
        Set<State> explored = new HashSet<>();
        List<State> initialPath = new ArrayList<>();
        initialPath.add(initialState);
        queue.add(initialPath);

        while (!queue.isEmpty()) {
            List<State> path = queue.poll();
            State current = path.get(path.size() - 1);

            if (current.isGoalState()) {
                return path;
            }

            explored.add(current);

            for (State successor : current.generateSuccessors()) {
                if (!explored.contains(successor)) {
                    List<State> newPath = new ArrayList<>(path);
                    newPath.add(successor);
                    queue.add(newPath);
                }
            }
        }

        return null;
    }
}
