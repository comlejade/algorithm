package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {
    private QuickSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        if (l >= r) return;

//        if (r - l + 1 <= 16) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }

        int p = partition(arr, l, r, random);
        // p 已经在它该在的位置，不需要处理
        sort(arr, l, p - 1, random);
        sort(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        // arr[l+1...j] < v; arr[j+1...i] >= v; 循环不变量
        // 如果选中第一个元素作为分界点开始比较
        // 对于完全有序的数组，每次都取第一个元素，递归的深度变成 n，时间复杂度变成了 O(n^2)
        // 为了解决这个问题，第一个元素改为随机去一个值，放到首位，作为分界点
        int p = random.nextInt(r - l + 1) + l;
        swap(arr, l, p);

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            // 对于小于分界点的元素放入 arr[l+1...j] < 的区间中
            // 对于大于等于分界点的元素都放在 arr[j+1...i] >= v 的区间中
            // 如果当前元素大于等于分界点元素，j不变，左侧区间不用往右扩展，所以只需要 i++ 即可，其他不用处理
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        // 将 l + 1开始，后面的元素都排好序之后，直接将 arr[l] 和 arr[j] 交换位置
        // 即将分界点放在它该在的位置
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest(MergeSort.class.getName(), "sort", arr2);
        SortingHelper.sortTest(QuickSort.class.getName(), "sort", arr);

        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest(MergeSort.class.getName(), "sort", arr);
        SortingHelper.sortTest(QuickSort.class.getName(), "sort", arr2);
    }
}
