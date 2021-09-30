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
      list = list + "{ " + current.getData()+ " } ->";
      current =current.getNext();
    }
    list = list + " null";
    return list;
  }

  public Node getHead() {
    return head;
  }
}
