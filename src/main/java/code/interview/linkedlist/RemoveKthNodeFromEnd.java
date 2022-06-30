package code.interview.linkedlist;

public class RemoveKthNodeFromEnd {

    // Use two pointers while traversing the linked list. First advance with the second pointer 'k'
    // positions, then traverse with both pointers until the end of the LinkedList, so that the
    // first pointer will have the kth position from the end that needs to be removed
    // For the edge case where the head needs to be removed, the head must be updated with the
    // next of the next node (value and next properties)
    // O(n) T
    // O(1) S
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        int counter = 1;
        LinkedList first = head;
        LinkedList second = head;
        while (counter <= k) {
            second = second.next;
            counter++;
        }
        if (second == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        while (second.next != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
    }

    static class LinkedList {

        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
