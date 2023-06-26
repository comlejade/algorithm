package structure;

import java.util.ArrayList;

import utils.FileOpreation;

/**
 * 链表实现集合 
 * 平均时间复杂度是O(n)
 */
public class LinkedListSet<E> implements Set<E> {

  private LinkedList<E> list;

  public LinkedListSet() {
    list = new LinkedList<>();
  }

  @Override
  public void add(E e) {
    if (!list.contains(e)) {
      list.addFirst(e);
    }
  }

  @Override
  public void remove(E e) {
    list.removeElement(e);
  }

  @Override
  public boolean contains(E e) {
    return list.contains(e);
  }

  @Override
  public int getSize() {
    return list.getSize();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }
  
  public static void main(String[] args) {
    System.out.println("双城记");

    ArrayList<String> words = new ArrayList<>();
    FileOpreation.readFile("src/utils/shuang.txt", words);
    System.out.println("total words: " + words.size());

    LinkedListSet<String> set1 = new LinkedListSet<>();
    for (String word : words) {
      set1.add(word);
    }

    System.out.println(set1.getSize());
  }
}
