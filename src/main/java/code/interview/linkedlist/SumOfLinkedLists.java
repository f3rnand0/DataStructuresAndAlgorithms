package code.interview.linkedlist;

public class SumOfLinkedLists {

    // Sum both numbers as if you were in school. Consider the carry when the sum is greater or
    // equal to 10. So the algorithm consists of iterating both Linked Lists at the same time and
    // getting the sum of every node value and the carry (if it exists). A dummy Linked List is
    // created at the beginning to have a reference of the head of the final sum of Linked Lists.
    // In every iteration a newNode LinkedList is created to store the sum of the current nodes,
    // then it's assigned to the currentNode.next Linked List, and finally the currentNode Linked
    // List will point to this newNode
    // O(n) T
    // O(n) S
    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList newLinkedListHeadPointer = new LinkedList(0);
        LinkedList currentNode = newLinkedListHeadPointer;
        int carry = 0;

        LinkedList nodeOne = linkedListOne;
        LinkedList nodeTwo = linkedListTwo;

        while (nodeOne != null || nodeTwo != null || carry != 0) {
            int valueOne = (nodeOne != null) ? nodeOne.value : 0;
            int valueTwo = (nodeTwo != null) ? nodeTwo.value : 0;
            int sumOfValues = valueOne + valueTwo + carry;

            int newValue = sumOfValues % 10;
            LinkedList newNode = new LinkedList(newValue);
            currentNode.next = newNode;
            currentNode = newNode;

            carry = sumOfValues / 10;
            nodeOne = (nodeOne != null) ? nodeOne.next : null;
            nodeTwo = (nodeTwo != null) ? nodeTwo.next : null;
        }

        return newLinkedListHeadPointer.next;
    }

    public static class LinkedList {

        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
