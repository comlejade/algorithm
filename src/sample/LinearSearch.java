package src.sample;

import src.ArrayGenerator;

public class LinearSearch {
  // 外部的类不能使用此类创建新的实例，只能调用静态方法
  private LinearSearch() {}
  
  public static <E> int search(E[] source, E target) {
    int index = -1;
    for (int i = 0; i < source.length; i++) {
      // if (source[i] == target) {
      if(source[i].equals(target)) {
        index = i;
      }
    }
    return index;
  }

  public static void main(String[] args) {
    // Integer[] data = {24, 18, 12, 9 ,16, 66, 32, 4};
    int[] dataSize = {1000000, 10000000};
    for (int n:dataSize) {
      // int n = 10000000;
      Integer[] data = ArrayGenerator.generateOrderedArray(n);
      long startTime = System.nanoTime(); // 纳秒
      // int index = LinearSearch.search(data, n);
      for (int k = 0; k < 100; k++) {
        LinearSearch.search(data, n);
      }
      long endTime = System.nanoTime();
      double time = (endTime - startTime) / (1000000000.0);
      System.out.println("n = " + n + ", 100 runs: " + time + "s");
    }
    // System.out.println(index);

    // int i = LinearSearch.search(data, 666);
    // System.out.println(i);

    // Student[] students = {new Student("aa"), new Student("bb"), new Student("cc")};
    // Student bb = new Student("bb");

    // int idx = LinearSearch.search(students, bb);
    // System.out.println(idx);
  }
}
