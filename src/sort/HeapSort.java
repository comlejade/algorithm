package sort;

import structure.heap.MaxHeap;
import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度O(nlogn)
 */
public class HeapSort {
    private HeapSort() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e: data) {
            maxHeap.add(e);
        }

        // 最大堆，每次取出堆顶的元素都是这个堆中的最大值
        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest(MergeSort.class.getName(), "sort", arr);
        SortingHelper.sortTest(QuickSort.class.getName(), "sort2ways", arr2);
        SortingHelper.sortTest(QuickSort.class.getName(), "sort3ways", arr3);
        SortingHelper.sortTest(HeapSort.class.getName(), "sort", arr4);
    }
}
