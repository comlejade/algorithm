package leetcode.lc303;

import structure.segment.SegmentTree;

public class NumArray {
    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public int sumRange(int left, int right) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null");
        }
        return segmentTree.query(left, right);
    }
}
