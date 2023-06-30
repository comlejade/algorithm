package structure.queue;

/**
 * 不使用size实现循环队列
 */
public class LoopQueue3<E> implements Queue<E> {
  private E[] data;
  private int front, tail;

  public LoopQueue3(int capacity) {
    data = (E[]) new Object[capacity + 1];
    front = 0;
    tail = 0;
  }

  public LoopQueue3() {
    this(10);
  }

  public int getCapacity() {
    return data.length - 1;
  }

  @Override
  public void enqueue(E e) {
    if ((tail + 1) % data.length == front) {
      resize(getCapacity() * 2);
    }
    data[tail] = e;
    tail = (tail + 1) % data.length;
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Queue is empty");
    }
    E ret = data[front];
    data[front] = null;
    front = (front + 1) % data.length;
    // System.out.println("dequeue size = " + getSize() + ", capacity = " + getCapacity());
    if (getSize() == getCapacity() / 4 && getCapacity() != 0) {
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
    if (tail >= front) {
      return tail - front;
    } else {
      return data.length + tail - front;
    }
  }

  @Override
  public boolean isEmpty() {
    return front == tail;
  }

  public void resize(int capacity) {
    E[] newData = (E[]) new Object[capacity + 1];
    int sz = getSize();
    for (int i = 0; i < sz ; i++) {
      newData[i] = data[(i + front) % data.length];
    }
    data = newData;
    front = 0;
    tail = sz;
  }
  
  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append(String.format("Queue: size = %d, capacity = %d\n", getSize(), getCapacity()));
    res.append("front [");
    for (int i = front; i != tail; i = (i + 1) % data.length) {
      res.append(data[i]);
      if ((i + 1) % data.length != tail) {
        res.append(", ");
      }
    }
    res.append("] tail");
    return res.toString();
  }

  public static void main(String[] args) {
    LoopQueue3<Integer> queue = new LoopQueue3<>();
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
