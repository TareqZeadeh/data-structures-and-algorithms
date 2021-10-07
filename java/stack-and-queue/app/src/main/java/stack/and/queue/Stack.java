package stack.and.queue;

public class Stack {
  private Node top;

  public Stack() {
    top = null;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public void push(String data) {
    if (isEmpty()) {
      Node newNode = new Node(data);
      top = newNode;
    } else {
      Node newNode = new Node(data);
      newNode.setNext(top);
      top = newNode;
    }
  }

  public String pop()throws Exception{
    if (isEmpty()) {
      System.out.println("The Stack Is Empty");
      throw new Exception("The Stack Is Empty");
    } else {
      String data = top.getData();
      top = top.getNext();
      return data;
    }
  }

  public String peek()throws Exception {
    if (isEmpty()) {
      System.out.println("The Stack Is Empty");
      throw new Exception("The Stack Is Empty");
    } else {
      return top.getNext().getData();
    }
  }
  public String peekNext()throws Exception{
    if(isEmpty()){
      System.out.println("The Stack Is Empty");
      throw new Exception("The Stack Is Empty");
    }else{
      return top.getNext().getData();
    }
  }

}
