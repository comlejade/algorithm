package src.sample;

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
    Integer[] data = {24, 18, 12, 9 ,16, 66, 32, 4};
    int index = LinearSearch.search(data, 16);
    System.out.println(index);

    int i = LinearSearch.search(data, 666);
    System.out.println(i);

    Student[] students = {new Student("aa"), new Student("bb"), new Student("cc")};
    Student bb = new Student("bb");

    int idx = LinearSearch.search(students, bb);
    System.out.println(idx);
  }
}
