package code.interview.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StaircaseTraversal {

    // The number of ways to get to the top is the following sum: numWays[k-1] + numWays[k-2] + ...
    // numWays[k-s] where s is the number of max steps. This solution repeats the calculations to
    // get the number of ways with many numbers (numWays[1] is being called to calculate
    // numWays[k-1], numberWays[k-2] and so on)
    // O(k^n) T
    // O(n) S, where n is the height of the staircase and k is the number of allowed steps
    public int staircaseTraversal(int height, int maxSteps) {
        return numberOfWaysToTop(height, maxSteps);
    }

    private int numberOfWaysToTop(int height, int maxSteps) {
        if (height <= 1) {
            return 1;
        }

        int numberOfWays = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numberOfWays += numberOfWaysToTop(height - step, maxSteps);
        }
        return numberOfWays;
    }

    // To avoid repetitive calculations a hash table is used to store them the first time and get
    // them if requested on next times. Start adding to that hash table the number of ways to top
    // with a staircase of 0 and 1
    // O(n * k) T
    // O(n) S, where n is the height of the staircase and k is the number of allowed steps
    public int staircaseTraversalMemoize(int height, int maxSteps) {
        HashMap<Integer, Integer> memoize = new HashMap<>();
        memoize.put(0, 1);
        memoize.put(1, 1);
        return numberOfWaysToTop(height, maxSteps, memoize);
    }

    private int numberOfWaysToTop(int height, int maxSteps, HashMap<Integer, Integer> memoize) {
        if (memoize.containsKey(height)) {
            return memoize.get(height);
        }

        int numberOfWays = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numberOfWays += numberOfWaysToTop(height - step, maxSteps);
        }
        memoize.put(height, numberOfWays);
        return numberOfWays;

    }

    // Using the same formula of previous solutions calculate the number of ways of minor heights.
    // But, there are also some calculations that are performed repetitively. Start adding to
    // the array the number of ways to top with a staircase of 0 and 1.
    // With the iterative approach the number of ways to top is obtained by the sum is calculated
    // by adding some previous number of ways to top (exactly the last 'allowed steps' previous
    // numbers of ways). Using the sliding window technique the number of ways to top of the
    // current height is calculated by adding the new previous number of ways that is inside
    // that window and subtracting the number of ways that no longer belongs to the window (after
    // moving to the right). The numbers that are inside the window are calculated on the first
    // steps, and only need to be added the new number, and subtracted the old number that's no
    // longer present in the window
    // O(n * k) T
    // O(n) S, where n is the height of the staircase and k is the number of allowed steps
    public int staircaseTraversalIterative(int height, int maxSteps) {
        int[] waysToTop = new int[height + 1];
        waysToTop[0] = 1;
        waysToTop[1] = 1;

        for (int currentHeight = 2; currentHeight < height + 1; currentHeight++) {
            int step = 1;
            while (step <= maxSteps && step <= currentHeight) {
                waysToTop[currentHeight] =
                    waysToTop[currentHeight] + waysToTop[currentHeight - step];
                step += 1;
            }
        }
        return waysToTop[height];
    }

    // O(n) T
    // O(n) S, where n is the height of the staircase
    public int staircaseTraversalIterativeOptimal(int height, int maxSteps) {
        int currentNumberOfWays = 0;
        List<Integer> waysToTop = new ArrayList<>();
        waysToTop.add(1);

        for (int currentHeight = 1; currentHeight < height + 1; currentHeight++) {
            int startOfWindow = currentHeight - maxSteps - 1;
            int endOfWindow = currentHeight - 1;

            if (startOfWindow >= 0) {
                currentNumberOfWays -= waysToTop.get(startOfWindow);
            }

            currentNumberOfWays += waysToTop.get(endOfWindow);
            waysToTop.add(currentNumberOfWays);
        }
        return waysToTop.get(height);
    }

    public static void main(String[] args) {
        StaircaseTraversal staircaseTraversal = new StaircaseTraversal();
        System.out.println(staircaseTraversal.staircaseTraversal(4, 2));
        System.out.println(staircaseTraversal.staircaseTraversalMemoize(4, 2));
        System.out.println(staircaseTraversal.staircaseTraversalIterative(4, 2));
        System.out.println(staircaseTraversal.staircaseTraversalIterativeOptimal(4, 2));
    }
}
