package stack.and.queue;

public class Queue {
  private Node front;
  private Node rear;

  public Queue() {
    this.front = null;
    this.rear = null;
  }
  public boolean isEmpty(){
    return front == null;
  }
  public void enqueue(String data){
    if(isEmpty()){
      Node newNode =new Node(data);
      front = newNode;
      rear = newNode;
    }else {
      Node newNode =new Node(data);
      rear.setNext(newNode);
      rear = newNode;
    }
  }
  public String dequeue()throws Exception{
    if(isEmpty()){
      System.out.println("The Queue Is Empty");
      throw new Exception("The Queue Is Empty");
    }else{
      String data = front.getData();
      front = front.getNext();
      return data;
    }
  }
  public String peek()throws Exception{
    if(isEmpty()){
      System.out.println("The Queue Is Empty");
      throw new Exception("The Queue Is Empty");
    }else{
      return front.getData();
    }
  }
  public String peekNext() throws Exception{
    if(isEmpty()){
      System.out.println("The Queue Is Empty");
      throw new Exception("The Queue Is Empty");
    }else{
      return front.getNext().getData();
    }
  }
}
