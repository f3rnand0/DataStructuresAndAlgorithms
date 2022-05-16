package code.interview.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumPassesMatrix {

    // The brute force approach visits many times every element of the matrix. Considering that
    // the positive values found in the first pass won't lead to conversion of any more negative
    // values in the next passes the time complexity can be improved. Only the neighbors
    // whose values were changed to positive can lead to change other negative values.
    // First, use one queue to store all the positions of the positive values and a second queue to
    // store the neighbors' positions that have a negative value and were converted to positive.
    // Iterate through the elements of first queue (current), change its negative neighbors to
    // poisitive and store them on a second queue (next); increment the number of passes by 1.
    // Then iterate through the second queue (now current) and do the same, change the element's
    // negative neighbors to positive and put them on the first queue (now next); increment the
    // number of passes by 1. And so on until all the values are positive.

    public static void main(String[] args) {
        // MinimumPassesOfMatrixUsingTwoQueues
        int[][] matrix = new int[][]{{0, -1, -3, 2, 0}, {1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};
        int expected = 3;
        int actual = new MinimumPassesMatrix().minimumPassesOfMatrixUsingTwoQueues(matrix);
        System.out.println("expected, actual " + expected + ", " + actual);
        assert (expected == actual);
        matrix = new int[][]{{1, 0, 0, -2, -3}, {-4, -5, -6, -2, -1}, {0, 0, 0, 0, -1},
            {-1, 0, 3, 0, 3}};
        expected = -1;
        actual = new MinimumPassesMatrix().minimumPassesOfMatrixUsingTwoQueues(matrix);
        System.out.println("expected, actual " + expected + ", " + actual);
        assert (expected == actual);

        // MinimumPassesOfMatrixUsingOneQueue
        matrix = new int[][]{{0, -1, -3, 2, 0}, {1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};
        expected = 3;
        actual = new MinimumPassesMatrix().minimumPassesOfMatrixUsingOneQueue(matrix);
        System.out.println("expected, actual " + expected + ", " + actual);
        assert (expected == actual);
        matrix = new int[][]{{1, 0, 0, -2, -3}, {-4, -5, -6, -2, -1}, {0, 0, 0, 0, -1},
            {-1, 0, 3, 0, 3}};
        expected = -1;
        actual = new MinimumPassesMatrix().minimumPassesOfMatrixUsingOneQueue(matrix);
        System.out.println("expected, actual " + expected + ", " + actual);
        assert (expected == actual);
    }

    // O(w * h) T
    // O(w * h) S where w os the width of the matrix and h is the height
    public int minimumPassesOfMatrixUsingTwoQueues(int[][] matrix) {
        int passes = convertNegativesUsingTwoQueues(matrix);
        return (!containsNegative(matrix)) ? passes - 1 : -1;
    }

    public int convertNegativesUsingTwoQueues(int[][] matrix) {
        Queue<int[]> nextPassQueue = getAllPositivePositions(matrix);
        int passes = 0;

        while (!nextPassQueue.isEmpty()) {
            Queue<int[]> currentPassQueue = nextPassQueue;
            nextPassQueue = new LinkedList<>();

            while (!currentPassQueue.isEmpty()) {
                int[] vals = currentPassQueue.poll();
                int currentRow = vals[0];
                int currentCol = vals[1];
                List<int[]> adjacentPositions =
                    getAdjacentPositions(currentRow, currentCol, matrix);

                for (int[] position : adjacentPositions) {
                    int row = position[0];
                    int col = position[1];
                    int value = matrix[row][col];
                    if (value < 0) {
                        matrix[row][col] *= -1;
                        nextPassQueue.add(new int[]{row, col});
                    }
                }
            }
            passes += 1;
        }
        return passes;
    }

    public Queue<int[]> getAllPositivePositions(int[][] matrix) {
        Queue<int[]> positivePositions = new LinkedList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int value = matrix[row][col];
                if (value > 0) {
                    positivePositions.add(new int[]{row, col});
                }
            }
        }
        return positivePositions;
    }

    public List<int[]> getAdjacentPositions(int row, int col, int[][] matrix) {
        List<int[]> adjacentPositions = new ArrayList<>();
        if (row > 0) {
            adjacentPositions.add(new int[]{row - 1, col});
        }
        if (row < matrix.length - 1) {
            adjacentPositions.add(new int[]{row + 1, col});
        }
        if (col > 0) {
            adjacentPositions.add(new int[]{row, col - 1});
        }
        if (col < matrix[0].length - 1) {
            adjacentPositions.add(new int[]{row, col + 1});
        }
        return adjacentPositions;
    }

    // Uses the sames reasoning as the previous algorithm by using a single queue to store at
    // first only the positions of all the positive values of the matrix, and then store in the
    // same queue the neighbors' positions that have a negative value and were converted to
    // positive.
    // To differentiate between positions of positive values and its neighbors uses a counter to
    // determine the number of elements (currentSize variable) that must be considered between
    // every pass of the matrix. Also, the increment by 1 of passes is done when he number of
    // elements is zero.

    public boolean containsNegative(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // O(w * h) T
    // O(w * h) S where w os the width of the matrix and h is the height
    public int minimumPassesOfMatrixUsingOneQueue(int[][] matrix) {
        int passes = convertNegativesUsingOneQueue(matrix);
        return (!containsNegative(matrix)) ? passes - 1 : -1;
    }

    public int convertNegativesUsingOneQueue(int[][] matrix) {
        Queue<int[]> queue = getAllPositivePositions(matrix);
        int passes = 0;

        while (!queue.isEmpty()) {
            int currentSize = queue.size();

            while (currentSize > 0) {
                int[] vals = queue.poll();
                int currentRow = vals[0];
                int currentCol = vals[1];
                List<int[]> adjacentPositions =
                    getAdjacentPositions(currentRow, currentCol, matrix);

                for (int[] position : adjacentPositions) {
                    int row = position[0];
                    int col = position[1];
                    int value = matrix[row][col];
                    if (value < 0) {
                        matrix[row][col] *= -1;
                        queue.add(new int[]{row, col});
                    }
                }
                currentSize -= 1;
            }
            passes += 1;
        }
        return passes;
    }
}
