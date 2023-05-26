package src.structure;

// 使用size，不浪费一个空间

public class LoopQueue2<E> implements Queue<E> {
  private E[] data;
  private int front, tail;
  private int size;

  public LoopQueue2(int capacity) {
    data = (E[]) new Object[capacity];
    front = 0;
    tail = 0;
    size = 0;
  }

  public LoopQueue2() {
    this(10);
  }

  public int getCapacity() {
    return data.length;
  }

  @Override
  public void enqueue(E e) {
    if (size + 1 == data.length) {
      resize(getCapacity() * 2);
    }
    data[tail] = e;
    tail = (tail + 1) % data.length;
    size++;
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Queue is empty");
    }
    E ret = data[front];
    data[front] = null;
    front = (front + 1) % data.length;
    size--;
    if (size == getCapacity() / 4) {
      resize(getCapacity() / 2);
    }
    return ret;
  }

  @Override
  public E getFront() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Queue is empty");
    }
    return data[front];
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  public void resize(int capacity) {
    E[] newData = (E[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      newData[i] = data[(i + front) % data.length];
    }
    data = newData;
    front = 0;
    tail = size;
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append(String.format("Queue: size= %d, capacity = %d\n", size, getCapacity()));
    res.append("front [");
    for (int i = front; i < size; i++) {
      res.append(data[(i + front) % data.length]);
      if ((i + front + 1) % data.length != tail) {
        res.append(", ");
      }
    }
    res.append("] tail");
    return res.toString();
  }

  public static void main(String[] args) {
    LoopQueue2<Integer> queue = new LoopQueue2<>();
    for (int i = 0; i < 10; i++) {
      queue.enqueue(i);
      System.out.println(queue);

      if (i % 3 == 2) {
        queue.dequeue();
        System.out.println(queue);
      }
    }
  }
}
