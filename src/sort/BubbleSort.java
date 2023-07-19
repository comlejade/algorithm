package sort;

public class BubbleSort {
    private BubbleSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j , j + 1);
                }
            }
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
