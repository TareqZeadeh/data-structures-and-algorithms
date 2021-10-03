package linked.list;

public class LinkedList {

  private Node head;

  public LinkedList() {
    head = null;
  }

  public void insert(String data) {
    Node newNode = new Node(data);
    if(head != null)
      newNode.setNext(head);
    head = newNode;
  }

  public boolean includes(String data){
    Node current = head;
    while (current!= null){
      if(current.getData()== data){
        return true;
      }
      current =current.getNext();
    }
    return false;
  }

  @Override
  public String toString() {
    Node current = head;
    String list ="";
    while (current!= null){
      list = list + "{ " + current.getData() + " } ->";
      current = current.getNext();
    }
    list = list + " null";
    return list;
  }

  public Node getHead() {
    return head;
  }


  public void append(String data) {
    Node newNode = new Node(data);
    if (head == null)
      head = newNode;
    else {
      Node current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newNode);
    }

  }

  public void insertBefore(String data, String newData) {
    Node newNode = new Node(newData);
    if (head == null)
      head = newNode;
    else if (head.getData() == data) {
      newNode.setNext(head);
      head = newNode;
    } else {
      Node current = head;
      while (current != null) {
        if (current.getNext().getData() == data) {
          newNode.setNext(current.getNext());
          current.setNext(newNode);
          break;
        }
        current = current.getNext();
      }
    }
  }

  public void insertAfter(String data, String newData) {
    Node newNode = new Node(newData);
    if (head == null)
      head = newNode;
    Node current = head;
    while (current != null) {
//      System.out.println(current.getData());
      if (current.getData() == data) {
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        break;
      }
      current = current.getNext();
    }
  }

  //---------------------------Stretch Goal-------------------
  public void delete(String data) {
    Node current = head;
    Node current1 = head.getNext();
    while (current1 != null) {

      if (current.getNext().getData() == data) {
        current.setNext(current1.getNext());
        current1.setNext(null);
        break;
      }
      current = current1;
      current1 = current1.getNext();
    }

  }
}
