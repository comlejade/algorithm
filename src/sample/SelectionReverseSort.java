package sample;

import utils.ArrayGenerator;
import utils.SortingHelper;

public class SelectionReverseSort {
  private SelectionReverseSort() {}

  public static <E extends Comparable<E>> void sort(E[] arr) {
    for (int i = arr.length - 1; i >= 0; i--) {
      int maxIndex = i;
      for (int j = i; j >= 0; j--) {
        if (arr[maxIndex].compareTo(arr[j]) < 0) {
          maxIndex = j;
        }
      }
      swap(arr, i, maxIndex);
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
      SortingHelper.sortTest(SelectionReverseSort.class.getName(), arr);
    }
    // Integer[] arr = {2,4,3,1,6,5};
    // SelectionReverseSort.sort(arr);
    // for (Integer i : arr) {
    //   System.out.println(i);
    // }
  }
}
