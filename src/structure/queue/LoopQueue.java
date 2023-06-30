package structure.queue;

/**
 * 循环队列
 */
public class LoopQueue<E> implements Queue<E> {
  private E[] data;
  private int front, tail;
  private int size;
  
  public LoopQueue(int capacity) {
    // 循环队列会浪费一个空间，用以判断 (tail + 1) % c = font，队列为满的状态
    // tail指向队列最后一个元素的下一位，如果不加一个空间，那么队列满的时候 front == tail
    // 这样就和队列为空的时候判断条件一样了，这里是选择空间换时间
    data = (E[]) new Object[capacity + 1];
    front = 0;
    tail = 0;
    size = 0;
  }

  public LoopQueue() {
    this(10);
  }

  public int getCapacity() {
    return data.length - 1;
  }

  @Override
  public void enqueue(E e) {
    // 取余的目的是让队列循环起来
    if ((tail + 1) % data.length == front) {
      resize(getCapacity() * 2);
    }
    data[tail] = e;
    tail = (tail + 1) % data.length;
    size++;
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Cannot dequeue from an empty queue");
    }
    E res = data[front];
    data[front] = null;
    front = (front + 1) % data.length;
    size--;
    if (size == getCapacity() / 4) {
      resize(getCapacity() / 2);
    }
    return res;
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
    return front == tail;
  }

  public void resize(int newCapacity) {
    E[] newData = (E[]) new Object[newCapacity + 1];
    for (int i = 0; i < size; i++) {
      // i + front 可能会越界，所以取余，
      newData[i] = data[(i + front) % data.length];
    }
    data = newData;
    front = 0;
    tail = size;
  }
  
  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
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
    LoopQueue<Integer> queue = new LoopQueue<>();
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
