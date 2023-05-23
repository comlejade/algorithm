package src.sample;

import src.ArrayGenerator;
import src.SortingHelper;

public class InsertionSort {
  private InsertionSort() {}

  public static <E extends Comparable<E>> void sort(E[] arr) {
    for (int i = 0; i < arr.length; i++) {
      E t = arr[i];
      int j = 0;
      for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
        arr[j] = arr[j - 1];
      }
      arr[j] = t;
      // for (int j = i; j - 1 >= 0; j--) {
      //   if (arr[j].compareTo(arr[j - 1]) < 0) {
      //     swap(arr, j, j - 1);
      //   } else {
      //     break;
      //   }
      // }
      // for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
      //   swap(arr, j, j - 1);
      // }
    }
  }

  private static <E> void swap(E[] arr, int i, int j) {
    E t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

  public static void main(String[] args) {
    int[] dataSize = {10000, 100000};
    for (int n : dataSize) {
      Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
      SortingHelper.sortTest(InsertionSort.class.getName(), arr);
    }
  }
}
