package code.interview.coins;


import java.util.Arrays;

public class NonConstructibleChange {

    // Ordering the array helps to define the minimum aomunt of change that cant be created.
    // During the iteration of every coin of the ordered array compare it with the amount of
    // change that can be currently created up to. Then there will be two scenarios:
    // 1.- The coin value is greater than the amount of change thta can be currently created plus
    // 1. So, return that amount because it can't be created
    // 2.- The coin value is smaller than or equal to the amount of change that can be currently
    // created plus 1. So, add the value to a cumulative variable and continue iterating through
    // the coins

    // O(n*log(n)) T
    // O(1) S
    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        int currentChangeCreated = 0;
        for (int coin : coins) {
            if (coin > currentChangeCreated + 1) {
                return currentChangeCreated + 1;
            }
            currentChangeCreated += coin;
        }
        return currentChangeCreated + 1;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 1, 2};
        System.out.println(NonConstructibleChange.nonConstructibleChange(coins));
        coins =  new int[]{1, 1, 4};
        System.out.println(NonConstructibleChange.nonConstructibleChange(coins));
        coins =  new int[]{1, 2, 3, 5, 20};
        System.out.println(NonConstructibleChange.nonConstructibleChange(coins));
    }

}
