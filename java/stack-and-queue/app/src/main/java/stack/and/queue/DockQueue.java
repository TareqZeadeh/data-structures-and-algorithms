package stack.and.queue;
import stack.and.queue.Generics.Node;
//public class circlerDuckQueue {
//  private Node front;
//  private Node rear;
//  int size;
//
//  public circlerDuckQueue() {
//    this.front = null;
//    this.rear = null;
//    this.size = 0;
//  }
//
//  public boolean isEmpty() {
//    return front == null;
//  }
//
//  public void enqueue(String data) {
//    Node newNode = new Node(data);
//    if (isEmpty()) {
//      front = newNode;
//      rear = newNode;
//    } else {
//      rear.setNext(newNode);
//      rear = newNode;
//      rear.setNext(front);
//    }
//    size++;
//  }
//
//  public String dequeue(int num,Node current,Node currentBefore) throws Exception {
//    if (isEmpty()) {
//      System.out.println("The Queue Is Empty");
//      throw new Exception("The Queue Is Empty");
//    } else {
//      for(int i=0; i<size;i++){
//        current = front;
//        currentBefore = rear;
//        for (int j = 0; j < num-1; j++) {
//          current = current.getNext();
//          currentBefore = currentBefore.getNext();
//        }
////      String data = current.getData();
//        if (current == front) {
//          String data = current.getData();
//          current = current.getNext();
//          rear.setNext(rear.getNext().getNext());
//          currentBefore.setNext(currentBefore.getNext().getNext());
//          front = current;
//          size--;
//          return data;
//        } else if (current == rear) {
//          String data = current.getData();
//          current = current.getNext();
//          rear = currentBefore;
//          currentBefore.setNext(currentBefore.getNext().getNext());
//          size--;
//          return data;
//        } else {
//          String data = current.getData();
//          current = current.getNext();
//          currentBefore.setNext(currentBefore.getNext().getNext());
//          size--;
//          return data;
//      }
//      }
//    }
//  }
//
//  public String peek() throws Exception {
//    if (isEmpty()) {
//      System.out.println("The Queue Is Empty");
//      throw new Exception("The Queue Is Empty");
//    } else {
//      return front.getData();
//    }
//  }
//
//  public Node getFront() {
//    return front;
//  }
//
//  public Node getRear() {
//    return rear;
//  }
//
//  public int getSize() {
//    return size;
//  }
//}
public class DockQueue<T> {
  private Node<T> front;
  private Node<T> back;
  private int size;

  public DockQueue() {
    front = back = null;
    size = 0;
  }

  public void enqueue(T data) {
    Node<T> node = new Node<>(data);
    if (isEmpty())
      front = node;
    else {
      back.setNext(node);
      node.setNext(front);
    }
    back = node;
    size++;
  }

  public T dequeue() throws Exception {
    T data;
    if (isEmpty())
      throw new Exception("Can't remove from empty Queue!");
    else {
      data = front.getData();
      front = front.getNext();
    }
    size--;
    return data;
  }

  public T peek() throws Exception {
    if (isEmpty())
      throw new Exception("Can't peek empty Queue!");
    else
      return front.getData();
  }

  public boolean isEmpty() {
    return front == null;
  }

  public T duckDuckGoose(int k) {
    if(k==0){
      System.out.println("The value should be greater than 0. ");
      return null;}
    if (!isEmpty()) {
      Node<T> current = front;
      Node<T> trace = front;
      int counter = 0;
      while (size != 1) {
        if (counter == k - 1) {
          System.out.printf("%s was removed\n", current.getData());
          trace.setNext(current.getNext());
          current = current.getNext();
          counter = 0;
          size--;
        } else {
          trace = current;
          current = current.getNext();
          counter++;
        }
      }
      return current.getData();
    }
    return null;
  }

  @Override
  public String toString() {
    String queueStr = getQueueString();
    return String.format("Front -> %s -> Back", queueStr);
  }

  private String getQueueString() {
    StringBuilder queueStr = new StringBuilder();
    if (!isEmpty()) {
      Node<T> current = front;
      while (current.getNext() != front) {
        queueStr.append(current.getData());
        if (current.getNext().getNext() != front)
          queueStr.append(" -> ");
        current = current.getNext();
      }
      queueStr.append(" -> ").append(current.getData());
    }
    return queueStr.toString();
  }

}
