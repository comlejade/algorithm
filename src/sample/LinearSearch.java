package src.sample;

public class LinearSearch {
  
  public static int search(int[] source, int target) {
    int index = -1;
    for (int i = 0; i < source.length; i++) {
      if (source[i] == target) {
        index = i;
      }
    }
    return index;
  }

  public static void main(String[] args) {
    int[] data = {24, 18, 12, 9 ,16, 66, 32, 4};
    int index = LinearSearch.search(data, 16);
    System.out.println(index);

    int i = LinearSearch.search(data, 666);
    System.out.println(i);
  }
}