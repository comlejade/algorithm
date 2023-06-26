package structure;
/**
 * 双端队列
 */
public class Deque<E> {
  private E[] data;
  private int front, tail;
  private int size;

  public Deque(int capacity) {
    data = (E[]) new Object[capacity + 1];
    front = 0;
    tail = 0;
    size = 0;
  }

  public Deque() {
    this(10);
  }

  public int getCapacity() {
    return data.length - 1;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E getFront() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Deque is empty");
    }
    return data[front];
  }

  public E getLast() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Deque is empty");
    }
    // tail 指向的是最后一个元素的下一个位置
    int index = tail == 0 ? data.length - 1 : tail - 1;
    return data[index];
  }

  public void resize(int capacity) {
    E[] newData = (E[]) new Object[capacity + 1];
    for (int i = 0; i < size; i++) {
      newData[i] = data[(i + front) % data.length];
    }
    data = newData;
    front = 0;
    tail = size;
  }

  public void addFront(E e) {
    if (tail + 1 == front) {
      resize(getCapacity() * 2);
    }
    
    if (front - 1 < 0) {
      front = data.length - 1;
    } else {
      front = front - 1;
    }

    data[front] = e;
    size++;
  }

  public void addLast(E e) {
    if (tail + 1 == front) {
      resize(getCapacity() * 2);
    }

    data[tail] = e;
    tail = (tail + 1) % data.length;
    size++;
  }

  public E removeFront() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Deque is empty");
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

  public E removeLast() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Deque is empty");
    }
    E ret = data[tail];
    data[tail] = null;
    if (tail - 1 >= 0) {
      tail = tail - 1;
    } else {
      tail = data.length - 1;
    }
    size--;
    if (size == getCapacity() / 4) {
      resize(getCapacity() / 2);
    }
    return ret;
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append(String.format("Deque: size = %d, capacity = %d\n", size, getCapacity()));
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
    Deque<Integer> queue = new Deque<>();
    for (int i = 0; i < 10; i++) {
      if (i < 5) {
        queue.addFront(i);
        System.out.println(queue);
      } else {
        queue.addLast(i);
        System.out.println(queue);
      }

      if (i % 3 == 2) {
        // queue.removeFront();
        queue.removeLast();
        System.out.println(queue);
      }
    }
  }
}
