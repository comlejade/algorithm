package utils;

import java.util.Random;

public class ArrayGenerator {
  private ArrayGenerator() { }

  public static Integer[] generateOrderedArray(int n) {
    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; i++) {
      arr[i] = i;
    }
    return arr;
  }

  // 生成长度为n的随机数组，每个数字范围[0, bound)
  public static Integer[] generateRandomArray(int n, int bound) {
    Integer[] arr = new Integer[n];
    Random rnd = new Random();
    for (int i = 0; i < n; i++) {
      arr[i] = rnd.nextInt(bound);
    }
    return arr;
  }

  public static Integer[] generateSpecialArray(int n) {
    Integer[] arr = new Integer[n];
    // 生成 arr[0...n-1]的测试用例，其中最小值是0
    generateSpecialArray(arr, 0, arr.length - 1, 0);
    return arr;
  }

  public static void generateSpecialArray(Integer[] arr, int l, int r, int value) {
    // 递归到底，如果l > r，要处理的区间是空，直接返回
    if (l > r) return;

    // 把最小值放中间
    int mid = (l + r) / 2;
    arr[mid] = value;

    // 模拟partition的过程，把中间元素和最左边元素交换位置
    swap(arr, l, mid);

    // 处理除了最左边的元素以外，剩下的n-1个元素
    generateSpecialArray(arr, l + 1, r, value + 1);

    // 处理好之后，还要把中间元素和最左边的元素交换回来
    swap(arr, l, mid);
  }

  private static <E> void swap(E[] arr, int i, int j) {
    E temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    generateSpecialArray(10);
  }
}
