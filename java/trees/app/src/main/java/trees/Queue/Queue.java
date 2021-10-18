package trees.Queue;

public class Queue<T> {
  private Node<T> front;
  private Node<T> rear;
  private int size;

  public Queue() {
    this.front = null;
    this.rear = null;
    size=0;
  }
  public boolean isEmpty(){
    return front == null;
  }

  public void enqueue(T data){
    Node<T> newNode =new Node<T>(data);
    if(isEmpty()){
      front = newNode;
    }else {
      rear.setNext(newNode);
    }
    rear = newNode;
    size++;
  }

  public T dequeue()throws Exception{
    if(isEmpty()){
      System.out.println("The Queue Is Empty");
      throw new Exception("The Queue Is Empty");
    }else{
      T data = front.getData();
      front = front.getNext();
      size--;
      return data;
    }
  }
  public T peek() throws Exception{
    if(isEmpty()){
      System.out.println("The Queue Is Empty");
      throw new Exception("The Queue Is Empty");
    }else{
      return front.getData();
    }
  }

  public int getSize() {
    return size;
  }
}
