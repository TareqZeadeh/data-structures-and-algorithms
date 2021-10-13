package stack.and.queue;

public class Queue {
  private Node front;
  private Node rear;
  int size;
  public Queue() {
    this.front = null;
    this.rear = null;
    size = 0;
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
    size++;
  }
  public String dequeue()throws Exception{
    if(isEmpty()){
      System.out.println("The Queue Is Empty");
      throw new Exception("The Queue Is Empty");
    }else{
      String data = front.getData();
      front = front.getNext();
      size--;
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

  public Node getFront() {
    return front;
  }

  public void setFront(Node front) {
    this.front = front;
  }

  public Node getRear() {
    return rear;
  }

  public void setRear(Node rear) {
    this.rear = rear;
  }

  public int getSize() {
    return size;
  }
}
