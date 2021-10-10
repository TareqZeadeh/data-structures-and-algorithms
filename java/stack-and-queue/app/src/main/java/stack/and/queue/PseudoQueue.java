package stack.and.queue;

import stack.and.queue.Interfaces.Queue;
// Code Challenge 11
public class PseudoQueue implements Queue {

  Stack stack1;
  Stack stack2;

  public PseudoQueue() {
    stack1 = new Stack();
    stack2= new Stack();
  }

  @Override
  public void enqueue(String data) {
    stack1.push(data);
  }
  @Override
  public String dequeue() throws Exception {
    if(stack1.isEmpty()){
      return "Queue Is Empty";
    }else {
    while (!stack1.isEmpty()){
      stack2.push(stack1.pop());
    }
    }
    System.out.println(stack2.peek());
    String data=stack2.pop();
    while (!stack2.isEmpty()){
      stack1.push(stack2.pop());
    }
    return data;
  }
}

