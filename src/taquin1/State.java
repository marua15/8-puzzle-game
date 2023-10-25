package taquin1;

import java.util.*;

public class State {
    private int[][] board;
    int cost;
    int depth;

    public State(int[][] board) {
        this.board = board;
        this.cost = 0;
        this.depth = 0;
    }

    public int getCost() {
        return cost;
    }

    public int getDepth() {
        return depth;
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean isGoalState() {
        int n = board.length;
        int m = board[0].length;
        int goalValue = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != goalValue % (n * m)) {
                    return false;
                }
                goalValue++;
            }
        }
        return true;
    }

    public List<State> generateSuccessors() {
        List<State> successors = new ArrayList<>();
        int n = board.length;
        int m = board[0].length;
        int x = -1, y = -1;

        // Find the position of the empty cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];
            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                int[][] newBoard = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        newBoard[i][j] = board[i][j];
                    }
                }
                newBoard[x][y] = board[newX][newY];
                newBoard[newX][newY] = 0;
                successors.add(new State(newBoard));
            }
        }

        return successors;
    }

    public void print() {
        for (int[] row : board) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        State state = (State) obj;
        return Arrays.deepEquals(board, state.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }
}
