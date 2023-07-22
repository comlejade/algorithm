package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

/**
 * 稳定
 */
public class BubbleSort {
    private BubbleSort() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i + 1 < data.length;) {
            // arr[n - i, n) 已排好序
            // 通过冒泡在 arr[n-i-1]位置上放合适的元素
//            boolean isSwapped = false;
            int lastSwappedIndex = 0;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
//                    isSwapped = true;
                    lastSwappedIndex = j + 1;
                }
            }

//            if (lastSwappedIndex == 0) break;
            i = data.length - lastSwappedIndex;
//            if (!isSwapped) {
//                break;
//            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = data.length - 1; j > i; j--) {
                if (data[j].compareTo(data[j - 1]) < 0) {
                    swap(data, j, j - 1);
                }
            }
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int n = 1000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//        Integer[] arr = ArrayGenerator.generateOrderedArray(n);

        SortingHelper.sortTest(BubbleSort.class.getName(), "sort2", arr);

    }
}
