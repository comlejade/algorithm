package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

/**
 * 归并排序整体的时间复杂度是O(n * logn)
 * 对于完全有序的数组，复杂度是O(n)
 * 稳定
 */
public class MergeSort {
    private MergeSort() {}

    // 自顶向下的归并排序
    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {
//        System.out.println("对" + Arrays.toString(Arrays.copyOfRange(arr, l, r)) + "进行排序, " + "l=" + l + ",r=" + r);
        if (l >= r) return;
        // 当元素个数较小的时候，转而使用插入排序
        // 对于高级语言，如脚本语言js等，这里的优化反而可能耗时更长
//        if (r - l <= 15) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }

        // 防止溢出
        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        // 这里归并是对两个有序的区间进行合并，如果 arr[mid] < arr[mid + 1], 说明这个区间本身是有序的，不用再归并
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    // 自底向上的归并排序
    public static <E extends Comparable<E>> void sortBU(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;
        // 遍历合并的区间长度
        for (int sz = 1; sz < n; sz += sz) {
            // 遍历合并的两个区间的起始位置 i
            // 合并 [i, i + sz - 1] 和 [i + sz, i + sz + sz - 1]
            for (int i = 0; i + sz < n; i += sz + sz) {
                // Math.min(i + sz + sz - 1, n - 1)  防止数组越界，因为最后的数组长度不一定满足sz
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
                }
            }
        }
    }

    // 利用插入排序进行优化
    public static <E extends Comparable<E>> void sortBU2(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;
        // 对数组大小为16的数组，进行插入排序，大于16的进行归并排序
        for (int i = 0; i < n; i+=16) {
            InsertionSort.sort(arr, i, Math.min(i + 15, n - 1));
        }


        // 遍历合并的区间长度
        for (int sz = 16; sz < n; sz += sz) {
            // 遍历合并的两个区间的起始位置 i
            // 合并 [i, i + sz - 1] 和 [i + sz, i + sz + sz - 1]
            for (int i = 0; i + sz < n; i += sz + sz) {
                // Math.min(i + sz + sz - 1, n - 1)  防止数组越界，因为最后的数组长度不一定满足sz
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
                }
            }
        }
    }

    // 合并两个有序的区间 arr[l, mid] 和 arr[mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
//        System.out.println("对" + Arrays.toString(Arrays.copyOfRange(arr, l, r)) + "进行归并, " + "l=" + l + ",mid=" + mid + ",r=" + r);
//        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        // 将arr中[l, r]区间的值拷贝到temp中
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l; int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
//                arr[k] = temp[j - l]; j++;
                arr[k] = temp[j]; i++;
            } else if (j > r) {
//                arr[k] = temp[i - l]; i++;
                arr[k] = temp[i]; i++;
//            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
            } else if (temp[i].compareTo(temp[j]) <= 0) {
//                arr[k] = temp[i - l]; i++;
                arr[k] = temp[i]; i++;
            } else {
//                arr[k] = temp[j - l]; j++;
                arr[k] = temp[j]; j++;
            }
        }
//        System.out.println("对" + Arrays.toString(Arrays.copyOfRange(arr, l, r)) + "进行归并后: " + Arrays.toString(Arrays.copyOfRange(arr, l, r)));
    }



    public static void main(String[] args) {
        int n = 10000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest(MergeSort.class.getName(), "sortBU2", arr);
//        SortingHelper.sortTest(MergeSort.class.getName(), "sort", arr);
    }
}
