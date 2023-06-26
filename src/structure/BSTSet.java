package structure;

import java.util.ArrayList;

import search.BinarySearchTree;
import utils.FileOpreation;

/**
 * 使用二分搜索树实现集合
 * 平均时间复杂度是 O(logn)
 * 可能退化成链表，时间复杂度是 O(n)
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

  private BinarySearchTree<E> bst;

  public BSTSet() {
    bst = new BinarySearchTree<>();
  }

  @Override
  public void add(E e) {
    bst.add(e);
  }

  @Override
  public void remove(E e) {
    bst.remove(e);
  }

  @Override
  public boolean contains(E e) {
    return bst.contains(e);
  }

  @Override
  public int getSize() {
    return bst.size();
  }

  @Override
  public boolean isEmpty() {
    return bst.isEmpty();
  }
  
  public static void main(String[] args) {
    System.out.println("双城记");

    ArrayList<String> words = new ArrayList<>();
    FileOpreation.readFile("src/utils/shuang.txt", words);
    System.out.println("total words: " + words.size());

    BSTSet<String> set1 = new BSTSet<>();
    for (String word : words) {
      set1.add(word);
    }

    System.out.println(set1.getSize());
  }
}
