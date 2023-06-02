package src.structure;

import java.util.Stack;

public class MyQueue {
  private Stack<Integer> stack = new Stack<>();
  
  public MyQueue() {
    stack = new Stack<>();
  }

  public void push(int x) {
    Stack<Integer> stack2 = new Stack<>();
    
    while(!stack.isEmpty()) {
      stack2.push(stack.pop());
    }

    stack.push(x);
    while(!stack2.isEmpty()) {
      stack.push(stack2.pop());
    }

  }
  
  public int pop() {
    return stack.pop();
  }
  
  public int peek() {
    return stack.peek();
  }
  
  public boolean empty() {
    return stack.isEmpty();
  }
}
