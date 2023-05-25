package src.structure;

public class ArrayStack<T> implements Stack<T> {
  Array<T> array;

  public ArrayStack(int capacity) {
    array = new Array<T>(capacity);
  }

  public ArrayStack() {
    array = new Array<>();
  }

  @Override
  public int getSize() {
    return array.getSize();
  }

  @Override
  public boolean isEmpty() {
    return array.isEmpty();
  }

  @Override
  public void push(T value) {
    array.addLast(value);
  }

  @Override
  public T pop() {
    return array.removeLast();
  }

  @Override
  public T peek() {
    return array.getLast();
  }

  public int getCapacity() {
    return array.getCapacity();
  }
}
