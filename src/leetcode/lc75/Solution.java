package leetcode.lc75;

import java.util.Random;

public class Solution {
    public void sortColors(int[] nums) {
        Random rnd = new Random();
        sort(nums, 0, nums.length - 1, rnd);
    }

    private void sort(int[] arr, int l, int r, Random rnd) {
        if (l >= r) return;

        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        int i = l + 1, lt = l, gt = r + 1;
        while (i < gt) {
            if (arr[i] < arr[l]) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i] > arr[l]) {
                gt--;
                swap(arr, i, gt);
            } else {
                i++;
            }
        }
        swap(arr, l, lt);

        sort(arr, l, lt - 1, rnd);
        sort(arr, gt, r, rnd);
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1};
        new Solution().sortColors(nums);
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < nums.length; i++) {
            res.append(nums[i]);
            if (i < nums.length - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        System.out.println(res.toString());
    }
}
