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
    }
  }

  public static void main(String[] args) {
    int[] dataSize = {10000, 100000};
    for (int n : dataSize) {
      Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
      SortingHelper.sortTest(InsertionSort.class.getName(), arr);

      // Integer[] arr2 = ArrayGenerator.generateOrderedArray(n);
      // SortingHelper.sortTest(InsertionSort.class.getName(), arr2);
    }
  }
}
