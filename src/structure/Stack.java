package src.structure;

public interface Stack<T> {
  int getSize();
  boolean isEmpty();
  void push(T value);
  T pop();
  T peek();
}
