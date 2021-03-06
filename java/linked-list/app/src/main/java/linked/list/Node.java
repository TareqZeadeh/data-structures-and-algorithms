package linked.list;

public class Node {
  private String data;
  private Node next;
  public Node(String data){
    this.next =null;
    this.data=data;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "Node{" +
      "data='" + data + '\'' +
      '}';
  }
}
