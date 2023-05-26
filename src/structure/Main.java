package src.structure;

import java.util.Random;

// import src.sample.Student;

public class Main {

  private static double testQueue(Queue<Integer> q, int opCount) {
    long startTime = System.nanoTime();

    Random random = new Random();
    
    for (int i = 0; i < opCount; i++) {
      q.enqueue(random.nextInt(Integer.MAX_VALUE));
    }

    for (int i = 0; i < opCount; i++) {
      q.dequeue();
    }

    long endTime = System.nanoTime();

    return (endTime - startTime) / 1000000000.0;
  }

  public static void main(String[] args) {
    int opCount = 100000;
    ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
    double time1 = testQueue(arrayQueue, opCount);
    System.out.println("ArrayQueue: " + time1 + "s");

    LoopQueue<Integer> loopQueue = new LoopQueue<>();
    double time2 = testQueue(loopQueue, opCount);
    System.out.println("LoopQueue: " + time2 + "s");

    // ArrayStack<Integer> stack = new ArrayStack<>();
    // for (int i = 0; i < 5; i++) {
    //   stack.push(i);
    //   System.out.println(stack);
    // }

    // stack.pop();
    // System.out.println(stack);
    // Array<Integer> arr = new Array<>(10);
    // for (int i = 0; i < 10; i++) {
    //   arr.addLast(i);
    // }
    // System.out.println(arr);

    // arr.add(1, 100);
    // System.out.println(arr);

    // arr.addFirst(-1);
    // System.out.println(arr);

    // arr.remove(2);
    // System.out.println(arr);

    // arr.removeElement(4);
    // System.out.println(arr);

    // arr.removeFirst();
    // System.out.println(arr);

    // arr.removeLast();
    // System.out.println(arr);

    // Array<Student> students = new Array<>();
    // students.addList(new Student("aa", 80));
    // students.addList(new Student("bb", 89));
    // students.addList(new Student("cc", 100));
    // System.out.println(students);
  }
}
