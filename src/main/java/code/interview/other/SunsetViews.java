package code.interview.other;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SunsetViews {

    // Iterate in the opposite direction to the buildings are facing, and compare every building
    // height with the current max height, which is the highest building after every iteration.
    // Then, add those indexes that are greater that the current max height.
    // Consider that the last building facing EAST (right), and the first building facing WEST
    // (left) will always have a sunset view.
    // O(n) T
    // O(n) S
    public List<Integer> sunsetViews(int[] buildings, String direction) {
        List<Integer> buildingsWithSunsetViews = new ArrayList<>();
        int startIdx = buildings.length - 1;
        int step = -1;

        if (direction.equals("WEST")) {
            startIdx = 0;
            step = 1;
        }

        int idx = startIdx;
        int runningMaxHeight = 0;

        while (idx >= 0 && idx < buildings.length) {
            if (buildings[idx] > runningMaxHeight) {
                buildingsWithSunsetViews.add(idx);
                runningMaxHeight = buildings[idx];
            }
            idx += step;
        }

        if (direction.equals("EAST")) {
            Collections.reverse(buildingsWithSunsetViews);
        }

        return buildingsWithSunsetViews;
    }

    // Iterate in the same direction as indicated in the direction argument and add to a stack
    // every item. Also, in evey iteration, remove from the Stack those buildings that are
    // blocked from seeing the sunset by the current building (those whose height is less or
    // equal than the current building)
    // O(n) T
    // O(n) S
    public List<Integer> sunsetViewsWithStack(int[] buildings, String direction) {
        Stack<Integer> candidateBuildings = new Stack<>();
        int startIdx = buildings.length - 1;
        int step = -1;

        if (direction.equals("EAST")) {
            startIdx = 0;
            step = 1;
        }

        int idx = startIdx;
        while (idx >= 0 && idx < buildings.length) {
            int buildingHeight = buildings[idx];

            while (!candidateBuildings.isEmpty()
                && buildings[candidateBuildings.peek()] <= buildingHeight) {
                candidateBuildings.pop();
            }
            candidateBuildings.add(idx);
            idx += step;
        }

        if (direction.equals("WEST")) {
            Collections.reverse(candidateBuildings);
        }

        return candidateBuildings;
    }

    public static void main(String[] args) {
        SunsetViews sunsetViews = new SunsetViews();
        System.out.println(sunsetViews.sunsetViews(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST"));
        System.out.println(sunsetViews.sunsetViews(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "WEST"));
        System.out.println(
            sunsetViews.sunsetViewsWithStack(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST"));
        System.out.println(
            sunsetViews.sunsetViewsWithStack(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "WEST"));
    }
}
