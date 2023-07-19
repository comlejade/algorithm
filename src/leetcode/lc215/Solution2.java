package leetcode.lc215;

import structure.heap.MinHeap;

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {

        MinHeap<Integer> heap = new MinHeap<>(k);
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (!heap.isEmpty() && nums[i] > heap.findMin()) {
                heap.extractMin();
                heap.add(nums[i]);
            }
        }

        return heap.findMin();
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int res = new Solution2().findKthLargest(arr, 2);
        System.out.println(res);
    }
}
