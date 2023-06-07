package sample;

import utils.ArrayGenerator;
import utils.SortingHelper;

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
//    int[] dataSize = {10000, 100000};
//    for (int n : dataSize) {
//      Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//      SortingHelper.sortTest(InsertionSort.class.getName(), arr);

      // Integer[] arr2 = ArrayGenerator.generateOrderedArray(n);
      // SortingHelper.sortTest(InsertionSort.class.getName(), arr2);
//    }
    Integer[] arr = {1,5,6,3,2,4,9,8,7};
    InsertionSort.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
      if (i < arr.length - 1) {
        System.out.print(", ");
      }
    }
  }
}
