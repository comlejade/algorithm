package src.structure;

public class Array<T> {
  private T[] data;
  private int size;

  /**
   * 构造函数，传入数组的容量capactiy构造Array
   * @param capacity
   */
  public Array(int capacity) {
    data = (T[]) new Object[capacity];
    size = 0;
  }

  /**
   * 无参构造，某人数组容量是10
   */
  public Array() {
    this(10);
  }

  /**
   * 获取数组元素个数
   * @return
   */
  public int getSize() {
    return size;
  }

  /**
   * 获取数组容量
   * @return
   */
  public int getCapacity() {
    return data.length;
  }

  /**
   * 数组是否为空
   * @return
   */
  public boolean isEmpty() {
    return data.length == 0;
  }

  /**
   * 向末位添加
   * @param e
   */
  public void addList(T e) {
    add(size, e);
  }

  /**
   * 向首位添加
   * @param e
   */
  public void addFirst(T e) {
    add(0, e);
  }

  /**
   * 在指定位置添加
   * @param index
   * @param e
   */
  public void add(int index, T e) {
    if (size == data.length) {
      throw new IllegalArgumentException("Add failed. Array is full.");
    }
    if (index < 0 || index > size) {
      // 数组可能会出现不连续
      throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= " + size + ".");
    }
    for (int i = size - 1; i >= index; i--) {
      data[i + 1] = data[i];
    }
    data[index] = e;
    size++;
  }

  /**
   * 获取index位置元素
   * @param index
   * @return
   */
  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Get failed. Index is illegal.");
    }
    return data[index];
  }

  /**
   * 设置index位置的值
   * @param index
   * @param value
   */
  public void set(int index, T value) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Get failed. Index is illegal.");
    }
    data[index] = value;
  }

  /**
   * 查看元素中是否包含元素e
   * @param e
   * @return
   */
  public boolean contains(T e) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(e)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 查找元素e在数组中的索引，没有则返回-1
   * @param e
   * @return
   */
  public int find(T e) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(e)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 从数组中删除索引为index的元素，并返回该元素
   * @param index
   * @return
   */
  public T remove(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Remove failed. Index is illegal.");
    }
    T t = data[index];
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    size--;
    return t;
  }

  public T removeFirst() {
    return remove(0);
  }

  public T removeLast() {
    return remove(size - 1);
  }

  /**
   * 从数组中删除元素
   * @param e
   */
  public void removeElement(T e) {
    int idx = find(e);
    if (idx != -1) {
      remove(idx);
    }
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
    res.append("[");
    for (int i = 0; i < size; i++) {
      res.append(data[i]);
      if (i != size - 1) {
        res.append(", ");
      }
    }
    res.append("]");
    return res.toString();
  }
}
