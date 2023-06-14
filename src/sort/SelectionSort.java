package sort;

import utils.ArrayGenerator;
import utils.SortingHelper;

/**
 * 选择排序的时间复杂度是O(n^2)
 */
public class SelectionSort {
  private SelectionSort() {}

  public static <E extends Comparable<E>> void sort(E[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int minIndex = i;
      for (int j = i; j < arr.length; j++) {
        if (arr[j].compareTo(arr[minIndex]) < 0) {
          minIndex = j;
        }
      }
      swap(arr, i, minIndex);
    }
  }

  private static <E> void swap(E[] arr, int i, int j) {
    E temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {

    // Integer[] arr = {1,4,2,3,6,5};
    // int n = 10000;
    int[] dataSize = {10000, 100000};
    for (int n : dataSize) {
      Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
      SortingHelper.sortTest(SelectionSort.class.getName(), "sort", arr);
    }
    // long startTime = System.nanoTime();
    // SelectionSort.sort(arr);
    // long endTime = System.nanoTime();

    // double time = (endTime - startTime) / 1000000000.0;
    // // 判断是否有序，检查排序算法是否有效
    // if (!SortingHelper.isSorted(arr)) {
    //   throw new RuntimeException("SelectionStort failed");
    // }
    // System.out.println(time + "s");
    // for (int i : arr) {
    //   System.out.print(i + " ");
    // }
    // System.out.println();

    // Student[] students = {
    //   new Student("aa", 80),
    //   new Student("bb", 77),
    //   new Student("cc", 100)
    // };
    // SelectionSort.sort(students);
    // for (Student student : students) {
    //   System.out.println(student);
    // }
  }
}
