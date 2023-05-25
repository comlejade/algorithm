package src.structure;

// import src.sample.Student;

public class Main {
  public static void main(String[] args) {
    Array<Integer> arr = new Array<>(10);
    for (int i = 0; i < 10; i++) {
      arr.addLast(i);
    }
    System.out.println(arr);

    arr.add(1, 100);
    System.out.println(arr);

    arr.addFirst(-1);
    System.out.println(arr);

    arr.remove(2);
    System.out.println(arr);

    arr.removeElement(4);
    System.out.println(arr);

    arr.removeFirst();
    System.out.println(arr);

    arr.removeLast();
    System.out.println(arr);

    // Array<Student> students = new Array<>();
    // students.addList(new Student("aa", 80));
    // students.addList(new Student("bb", 89));
    // students.addList(new Student("cc", 100));
    // System.out.println(students);
  }
}
