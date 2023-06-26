package structure;

/**
 * 单向链表
 */
public class LinkedList<E> {
  private class Node {
    public E e;
    public Node next;

    public Node(E e, Node next) {
      this.e = e;
      this.next = next;
    }

    public Node(E e) {
      this(e, null);
    }

    public Node() {
      this(null, null);
    }

    @Override
    public String toString() {
      return e.toString();
    }
  }

  private Node dummyHead; // 虚拟头节点
  private int size;

  public LinkedList() {
    // head = null;
    dummyHead = new Node(null, null);
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  // 在头部添加
  public void addFirst(E e) {
    // Node node = new Node(e);
    // node.next = head;
    // head = node;
    // 跟上面三步的效果一样
    // head = new Node(e, head);
    add(0, e);
    // size++;
  }

  public void add(int index, E e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("index Illegal.");
    }
    // if (index == 0) {
    //   addFirst(e);
    // } else {
      Node prev = dummyHead;
      // 查找当前 index 位置的元素
      for (int i = 0; i < index; i++) {
        prev = prev.next;
      }
      // Node node = new Node(e);
      // node.next = prev.next;
      // prev.next = node;
      prev.next = new Node(e, prev.next);
      size++;
    // }
  }

  // 在末尾添加
  public void addLast(E e) {
    add(size, e);
  }

  // 获取链表中 index 位置的元素
  public E get(int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("index Illegal.");
    }
    Node cur = dummyHead.next;
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    return cur.e;
  }

  // 获取链表的第一个元素
  public E getFirst() {
    return get(0);
  }

  // 获取链表的最后一个元素
  public E getLast() {
    return get(size - 1);
  }

  // 修改链表中 index 位置的元素
  public void set(int index, E e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("index Illegal.");
    }
    Node cur = dummyHead.next;
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    cur.e = e;
  }

  // 查找链表中是否有元素e
  public boolean contains(E e) {
    Node cur = dummyHead.next;
    while(cur != null) {
      if (cur.e.equals(e)) {
        return true;
      }
      cur = cur.next;
    }
    return false;
  }

  // 删除 index 位置元素
  public E remove(int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("index Illegal.");
    }
    Node prev = dummyHead;
    for (int i = 0; i < index; i++) {
      prev = prev.next;
    }
    Node retNode = prev.next;
    prev.next = retNode.next;
    retNode.next = null;
    size--;
    return retNode.e;
  }

  public E removeFirst() {
    return remove(0);
  }

  public E removeLast() {
    return remove(size - 1);
  }

  public void removeElement(E e) {
    Node prev = dummyHead;
    while (prev.next != null) {
      if (prev.next.e.equals(e)) {
        break;
      }
      prev = prev.next;
    }
    
    if (prev.next != null) {
      Node retNode = prev.next;
      prev.next = retNode.next;
      retNode.next = null;
      size--;
    }
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();

    Node cur = dummyHead.next;
    while(cur != null) {
      res.append(cur + "->");
      cur = cur.next;
    }

    // for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
    //   res.append(cur + "->");
    // }

    res.append("NULL");
    return res.toString();
  }

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < 5; i++) {
      linkedList.addFirst(i);
      System.out.println(linkedList);
    }
    linkedList.add(2, 666);
    System.out.println(linkedList);
    linkedList.remove(2);
    System.out.println(linkedList);
    linkedList.removeFirst();
    System.out.println(linkedList);
    linkedList.removeLast();
    System.out.println(linkedList);
  }
}
