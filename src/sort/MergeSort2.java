package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

public class MergeSort2 {
    private MergeSort2() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
//        System.out.println("对" + Arrays.toString(Arrays.copyOfRange(arr, l, r)) + "进行排序, " + "l=" + l + ",r=" + r);
        if (l >= r) return;
        // 防止溢出
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 这里归并是对两个有序的区间进行合并，如果 arr[mid] < arr[mid + 1], 说明这个区间本身是有序的，不用再归并
//        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
//        }
    }

    // 合并两个有序的区间 arr[l, mid] 和 arr[mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
//        System.out.println("对" + Arrays.toString(Arrays.copyOfRange(arr, l, r)) + "进行归并, " + "l=" + l + ",mid=" + mid + ",r=" + r);
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l; int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l]; j++;
            } else if (j > r) {
                arr[k] = temp[i - l]; i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l]; i++;
            } else {
                arr[k] = temp[j - l]; j++;
            }
        }
//        System.out.println("对" + Arrays.toString(Arrays.copyOfRange(arr, l, r)) + "进行归并后: " + Arrays.toString(Arrays.copyOfRange(arr, l, r)));
    }
}
