package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
  private Queue<Integer> q;

  public MyStack() {
    q = new LinkedList<>();
  }

  public void push(int x) {
    q.add(x);
  }

  public int pop() {
    Queue<Integer> q2 = new LinkedList<>();

    while(q.size() > 1) {
      q2.add(q.remove());
    }

    int ret = q.remove();
    q = q2;

    return ret;
  }

  public int top() {
    int ret = pop();
    push(ret);
    return ret;
  }

  public boolean empty() {
    return q.isEmpty();
  }
}
