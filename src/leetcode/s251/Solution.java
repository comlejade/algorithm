package leetcode.s251;

import java.util.Random;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Random rnd = new Random();
        return selectK(nums, 0, nums.length - 1, nums.length - k, rnd);
    }

    private int selectK(int[] arr, int l, int r, int k, Random rnd) {
        int p = partition(arr, l, r, rnd);


        if (k > p) {
            return selectK(arr, p + 1, r, k, rnd);
        }

        if (k < p) {
            return selectK(arr, l, p - 1, k, rnd);
        }

        return arr[p];
    }

    private int partition(int[] arr, int l, int r, Random rnd) {
        int p = rnd.nextInt(r - l + 1) + l;
        swap(arr, l, p);

        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i] < arr[l]) {
                i++;
            }

            while (i <= j && arr[j] > arr[l]) {
                j--;
            }

            if (i >= j) break;

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);
        return j;
    }


    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {12,34};
        int k = 1;
        System.out.println(new Solution().findKthLargest(nums, k));
    }
}
