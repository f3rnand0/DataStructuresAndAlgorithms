package code.interview.tree;


import java.util.List;

public class MinHeapConstruction {

    static class MinHeap {

        List<Integer> heap;

        // A heap is a binary tree that satisfies two properties:
        // 1. Completeness: every level of the BT is complete except for the last one that must
        // be filled from left to the right
        // 2. A heap property: for a min heap every node's value is smaller than or equal to its
        // children's nodes values. And for a max heap every node's value is greater than or
        // equal to its children's nodes values. And for a max heap
        // Can be represented on arrays. To find children nodes use these formulas: (2 * i) + 1 and
        // (2 * i) + 2. To determine a parent of a node use this formula: floor((i - 2) / 1)
        // The buildHeap, insert and remove methods use the siftUp and siftDown methods. siftUp
        // method exchange smaller nodes with its ancestors. siftDown method exchange greater
        // parent with its children

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        // Starts from the last parent node, sifts down if it's smaller than its children, then
        // continues with the other parent nodes in descending order to sift down those smaller
        // parents.
        // Can be performed using sift up method, but it will imply a n*log(n) time complexity
        // O(n) T
        // O(1) S
        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size() - 2) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        // Exchanges a parent node with one of its smaller children. The children to exchange is
        // the one with the least value
        // O(log(n)) T
        // O(1) S
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOneIdx = (currentIdx * 2) + 1;
            while (childOneIdx <= endIdx) {
                int childTwoIdx = (currentIdx * 2) + 2 <= endIdx ? (currentIdx * 2) + 2 : -1;
                int idxToSwap;
                if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx;
                }
                if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                    swap(currentIdx, idxToSwap, heap);
                }
            }
        }

        // Exchange a children node with its greater parent node
        // O(log(n)) T
        // O(1) S
        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        // O(1) T
        // O(1) S
        public int peek() {
            return heap.get(0);
        }

        // First swaps the first and last element of the array. Then, removes the last value.
        // And finally, sifts down the new root value in case there are greater children nodes
        // O(log(n)) T
        // O(1) S
        public int remove() {
            swap(0, heap.size() - 1, heap);
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        // Adds a value to the end of the array. Then sifts up this new value in case its parents
        // are greater
        // O(log(n)) T
        // O(1) S
        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        private void swap(int i, int j, List<Integer> array) {
            int temp = array.get(j);
            array.set(j, array.get(i));
            array.set(i, temp);
        }
    }
}
