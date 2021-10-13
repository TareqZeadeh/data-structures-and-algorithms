package stack.and.queue.Generics;

public class Node<T> {
  T data;
  Node<T> next;

  public Node(T data) {
    this.data = data;
    next = null;
  }

  public void setNext(Node<T> next){
    this.next = next;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setData(T data){
    this.data = data;
  }

  public T getData(){
    return data;
  }

  @Override
  public String toString() {
    return "Node{" +
      "data=" + data +
      '}';
  }
}
