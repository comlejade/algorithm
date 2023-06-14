package utils;

import java.lang.reflect.Method;


public class SortingHelper {
  private SortingHelper() { }

  public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1].compareTo(arr[i]) > 0) return false; 
    }
    return true;
  }
  
  public static <E extends Comparable<E>> void sortTest(String className, String method, E[] arr) {
    try {
      Class<?> sortClass = Class.forName(className);
      Method sortMethod = sortClass.getMethod(method, Comparable[].class);
      long startTime = System.nanoTime();
      sortMethod.invoke(null, new Object[]{arr});
      long endTime = System.nanoTime();
  
      double time = (endTime - startTime) / 1000000000.0;
      // 判断是否有序，检查排序算法是否有效
      if (!SortingHelper.isSorted(arr)) {
        throw new RuntimeException(className + " failed");
      }
      System.out.printf("%s, n = %d : %f s%n", className, arr.length, time);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
