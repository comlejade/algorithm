package sort;

import structure.heap.MaxHeap;
import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度O(nlogn)
 * 不稳定
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

    // 原地排序
    public static <E extends Comparable<E>> void sort2(E[] data) {
        if (data.length <= 1) return;

        // 将data整理成最大堆
        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            // 将堆顶的元素和 i 位置的元素交换位置
            swap(data, 0, i);
            // 然后将 0 到 i 位置之前（不包含 i ）的元素整理成最大堆
            siftDown(data, 0, i);
        }
    }

    // 对 data[0, n) 所形成的最大堆中，索引为 k 的元素，执行 siftDown
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
        while (k * 2 + 1 < n) {
            // 获取左孩子索引
            int j = k * 2 + 1;

            // 如果左孩子的值小于右孩子的值
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0) {
//                j = k * 2 + 2;
                j++;
            }

            // 上面找到了左右两个孩子中的最大值，索引为 j，如果 data.get(k) 处的值大于等于 data.get(j)
            // 那么data.get(k)已经在合适的位置了
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }

            // 如果不符合上面的条件，就交换k和子树中最大值j的位置
            swap(data, k, j);
            k = j;
        }
    }

    private static <E extends Comparable<E>> void swap(E[] data, int i, int j) {
        E tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
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
        SortingHelper.sortTest(HeapSort.class.getName(), "sort2", arr4);
    }
}
