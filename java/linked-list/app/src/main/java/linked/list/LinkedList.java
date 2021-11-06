package linked.list;

public class LinkedList {

  private Node head;

  public LinkedList() {
    head = null;
  }

  public void insert(String data) {
    Node newNode = new Node(data);
    if (head != null)
      newNode.setNext(head);
    head = newNode;
  }

  public boolean includes(String data) {
    Node current = head;
    while (current != null) {
      if (current.getData() == data) {
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  @Override
  public String toString() {
    Node current = head;
    String list = "";
    while (current != null) {
      list = list + "{ " + current.getData() + " } ->";
      current = current.getNext();
    }
    list = list + " null";
    return list;
  }

  public Node getHead() {
    return head;
  }
//----------------------------challenge06--------------------------------

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

  //---------------------------Stretch Goal challenge06 -------------------
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

  //----------------------------challenge07--------------------------------


  public int size() {
    int size = 0;
    Node current = head;
    while (current != null) {
      size++;
      current = current.getNext();
    }
    System.out.println(size);
    return size;
  }

  public String kthFromEnd(int kth) {
    Node current = head;
    int size = size();
    if (kth < size && kth >= 0) {
      while (size-- >= 0) {
        if (size == kth) {
          return current.getData();
        }
        current = current.getNext();
      }
    } else if (kth >= size) {
      try {
        throw new Exception("Out Of List Rang");
      } catch (Exception exception) {
        exception.printStackTrace();
      }

    } else if (kth < 0) {
      try {
        throw new Exception("Negative numbers is not allowed");
      } catch (Exception exception) {
        exception.printStackTrace();
      }
    }
    return "NO Results";
  }


  //----------------------------challenge08--------------------------------


  public static LinkedList zipLists(LinkedList list1, LinkedList list2) {
    if (list1.head != null && list2.head == null) {
      System.out.println("The second list is empty");
      return list1;
    } else if (list1.head == null && list2.head != null) {
      System.out.println("The first list is empty");
      return list2;
    } else if (list1.head == null && list2.head == null) {
      throw new NullPointerException("Both of lists are empty");
    }
    Node current1 = list1.head;
    Node current2 = list2.head;
    int length1 = list1.size();
    int length2 = list2.size();
    int indexCount = 0;
    while (current1.getNext() != null) {
      list1.insertAfter(indexCount, current2.getData());
      if (current2.getNext() == null) {
        break;
      } else {
        current1 = current1.getNext().getNext();
        current2 = current2.getNext();
        indexCount = indexCount + 2;
      }
    }
    if (length2 >= length1) {
      while (current2 != null) {
        list1.append(current2.getData());
        current2 = current2.getNext();
      }
    }
    return list1;
  }


  public Boolean insertAfter(int idx, String Data) {
    Node newNode = new Node(Data);
    if (head == null) {
      head = newNode;
      return true;
    } else {
      int idxCount = 0;
      Node current = head;
      while (current != null) {
        if (idxCount == idx) {
          newNode.setNext(current.getNext());
          current.setNext(newNode);
          idxCount++;
          break;
        }
        idxCount++;
        current = current.getNext();
      }
      return true;
    }
  }


  //--------------------------Linked List Reverser------------------------------------


  public static LinkedList LinkedListReverser(LinkedList list) {
    Node current = list.head;
    LinkedList list1 = new LinkedList();
    if (list.size() == 0) {
      System.out.println("Empty linked list passed to the method , will return empty linked list ");
    } else {
      while (current != null) {
        list1.insert(current.getData());
        current = current.getNext();
      }
    }

    return list1;
  }

  //=========================Is Palindrome=================================
  public boolean isPalindrome() {
    Node fast = head;
    Node slow = head;
    while (fast != null && fast.getNext() != null) {
      fast = fast.getNext().getNext();
      slow = slow.getNext();
    }
    slow = reversed(slow);
    fast = head;
    while (slow != null) {
      if (slow.getData() != fast.getData()) {
        return false;
      }
      slow = slow.getNext();
      fast = fast.getNext();
    }
    return true;
  }

  private Node reversed(Node head){
    Node prev = null;
    Node current = head;
    Node next = null;
    while (current != null){
      next = current.getNext();
      current.setNext(prev);
      prev = current;
      current = next;
    }
    return prev;
  }

  public void reverser(){
    Node prev = null;
    Node current = head;
    Node next = null;
    while (current != null){
      next = current.getNext();
      current.setNext(prev);
      prev = current;
      current = next;
    }
    head = prev;
  }
}

//===============================


//while (current1 != null) {
//  length1++;
//  current1 = current1.getNext();
//  }
//  while (current2 != null) {
//  length2++;
//  current2 = current2.getNext();
//  }
//  current1 = list1.getHead();
//  current2 = list2.getHead();
//  int maxLength = Math.max(length1,length2);
//  for (int i=0;i<maxLength;i++){
//  if(current1!=null){
//  zippedList.append(current1.getData());
//  current1=current1.getNext();
//  }if(current2!=null){
//  zippedList.append(current2.getData());
//  current2=current2.getNext();
//  }
//  }
