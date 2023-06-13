package sort;

/**
 * 插入排序的总体时间复杂度是O(n^2)
 * 对完全有序的数组是O(n)
 */
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

  public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

    for (int i = l; i <= r; i++) {
      E t = arr[i];
      int j;
      for (j = i; j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j--) {
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
