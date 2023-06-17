package leetcode.s704;

public class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private static int search(int[] data, int l, int r, int target) {
        if (l > r) return -1;

        int mid = l + (r - l) / 2;

        if (data[mid] == target) return mid;

        if (data[mid] < target) {
            return search(data, mid + 1, r, target);
        }

        return search(data, l, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        int target = 9;
        int res = new Solution().search(arr, target);
        System.out.println(res);
    }
}
