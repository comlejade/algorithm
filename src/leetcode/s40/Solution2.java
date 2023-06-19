package leetcode.s40;

import java.util.Arrays;
import java.util.Random;

public class Solution2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        Random rnd = new Random();
        selectK(arr, 0, arr.length, k - 1, rnd);
        return Arrays.copyOf(arr, k);
    }

    private int selectK(int[] arr, int l, int r, int k, Random rnd) {
        int p = partition(arr, l, r - 1, rnd);
        if (k == p) return arr[p];

        if (k < p) {
            return selectK(arr, l, p - 1, k, rnd);
        } else {
            return selectK(arr, p + 1, r, k, rnd);
        }
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

            if (i >= j) {
                break;
            }

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
        int[] arr = {0,1,2,1};
        int k = 3;

        int[] res = new Solution2().getLeastNumbers(arr, k);

        System.out.println(Arrays.toString(res));
    }
}
