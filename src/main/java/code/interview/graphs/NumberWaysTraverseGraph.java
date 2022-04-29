package code.interview.graphs;


public class NumberWaysTraverseGraph {

    // The number of ways to reach at a specific position is the sum of "the number of ways to
    // reach the position above it (previousTop) and the number of ways to reach the position
    // directly yo the left (previousLeft). Starting on the bottom right recursively produce the
    // number of ways knowing that in the top or left edges there's only one way to reach that
    // position

    // O(2^(n+m)) T. 2 because there are two possible ways to advance(left and up), and n+m
    // because is the number of iterations needed to get to the top left
    // O(n+m) S
    public int numberOfWaysToTraverseGraphRecursive(int width, int height) {
        if (width == 1 || height == 1) {
            return 1;
        }
        return numberOfWaysToTraverseGraphRecursive(width - 1, height)
            + numberOfWaysToTraverseGraphRecursive(width, height - 1);
    }

    // Using the same principle as above traverse the graph column by column considerin that the
    // number of ways to reach to top and left edges is 1. For the other positions the number of
    // ways to reach them is the sum of "the number of ways to reach 'previous top position; and
    // 'previous left position'"

    // O(n*m) T. Two fors-loops are used to traverse the graph
    // O(n*m) S. A two-dimension array is needed
    public int numberOfWaysToTraverseGraphIterative(int width, int height) {
        int[][] numberOfWays = new int[height + 1][width + 1];

        for (int widthIdx = 0; widthIdx < width + 1; widthIdx++) {
            for (int heightIdx = 0; heightIdx < height + 1; heightIdx++) {
                if (widthIdx == 1 || heightIdx == 1) {
                    numberOfWays[heightIdx][widthIdx] = 1;
                } else {
                    int waysLeft = numberOfWays[heightIdx][widthIdx - 1];
                    int waysUp = numberOfWays[heightIdx - 1][widthIdx];
                    numberOfWays[heightIdx][widthIdx] = waysLeft + waysUp;
                }
            }
        }
        return numberOfWays[height][width];
    }
}
