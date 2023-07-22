package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

import java.util.Arrays;

/**
 * 数组逐步变得有序
 * 时间复杂度在数据规模小的时候，与O(nlogn)差不多
 * 在 O(nlogn) - O(n^2) 之间
 */
public class ShellSort {
    private ShellSort() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        // 元素间隔
        int h = data.length / 2;

        while (h >= 1) {
            // 数据可以一个一个挨着处理，不一定要分组
            // 但是每一个元素的下一个元素都要隔着h个元素去找
            // 对 data[h, n) 进行插入排序
            for (int i = h; i < data.length; i++) {
                E t = data[i];
                int j;
                for (j = i; j - h >= 0 && t.compareTo(data[j-h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = t;
            }

            h = h / 2;
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {
        // 步长
        int h = 1;
        while (h < data.length) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            // 数据可以一个一个挨着处理，不一定要分组
            // 但是每一个元素的下一个元素都要隔着h个元素去找
            // 对 data[h, n) 进行插入排序
            for (int i = h; i < data.length; i++) {
                E t = data[i];
                int j;
                for (j = i; j - h >= 0 && t.compareTo(data[j-h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = t;
            }

            // 利用计算机整除的特性，不用减 1
            h = h / 3;
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] data) {
        // 元素间隔
        int h = data.length / 2;

        while (h >= 1) {
            // 将数据分组，遍历每一组
            for (int start = 0; start < h; start++) {
                // 遍历组内的元素
                // 并对于组内的元素进行插入排序
                // 对 data[start, start + h, start + 2h, start + 3h...] 进行插入排序
                for (int i = start + h; i < data.length; i += h) {
                    E t = data[i];
                    int j;
                    for (j = i; j - h >= 0 && t.compareTo(data[j -h]) < 0; j -= h) {
                        // 如果data[j] 比 data[j-h]小，那么就将元素向后挪，给t腾位置
                        data[j] = data[j - h];
                    }
                    data[j] = t;
                }
            }

            h = h / 2;
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
//        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
//        Integer[] arr4 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest(ShellSort.class.getName(), "sort", arr);
        SortingHelper.sortTest(ShellSort.class.getName(), "sort2", arr2);
//        SortingHelper.sortTest(HeapSort.class.getName(), "sort", arr3);
//        SortingHelper.sortTest(QuickSort.class.getName(), "sort2ways", arr4);
//        SortingHelper.sortTest(BubbleSort.class.getName(), "sort", arr3);
    }
}
