/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linked.list;

import java.util.ArrayList;
import java.util.List;

public class App {
  public String getGreeting() {
    return "Hello World!";
  }

public static boolean isListPalindrome(LinkedList list){
  List<String> list1 = new ArrayList<>();
  List<String> list2 = new ArrayList<>();
  Node current = list.getHead();
  while (current != null){
    list1.add(current.getData());
    current = current.getNext();
  }
  for (int i = list1.size() - 1; i > -1; i--){
    list2.add(list1.get(i));
  }
  System.out.println(list1);
  System.out.println(list2);
//  for(int i=0; i<list1.size(); i++ ){
//    if(!list1.get(i).equals(list2.get(i))){return false;}
//  }
  if(list1.toString().equals(list2.toString()))
      return true;
  else return false;
}
//=====================================
  public static boolean isTextInList(LinkedList list, String string){
    Node current = list.getHead();
    while (current != null){
      if(current.getData() == string){return true;}
      current = current.getNext();
    }
    return false;
  }
  public static void main(String[] args) {
//        System.out.println(new App().getGreeting());

    LinkedList linkedList = new LinkedList();
    linkedList.insert("T");
    linkedList.insert("A");
    linkedList.insert("R");
    linkedList.insert("I");
    linkedList.insert("Q");
    linkedList.append("2");
    linkedList.insertBefore("2", "3");
    linkedList.insertAfter("3", "4");
//    System.out.println(linkedList);
    linkedList.delete("3");
//    System.out.println(linkedList);
//    System.out.println(linkedList.includes("H"));
//    System.out.println(linkedList.includes("T"));
//    String str =linkedList.kthFromEnd(3);
//    System.out.println(str);

    System.out.println("=================================================================================");
    System.out.println("=================================================================================");
    LinkedList list1=new LinkedList();
    LinkedList list2=new LinkedList();
    list1.append("1");
    list1.append("3");
    list1.append("2");
    list1.append("8");
    list1.append("10");
    list1.append("11");
    list1.append("12");
    list1.append("13");
    System.out.println(list1);
    list2.append("5");
    list2.append("9");
    list2.append("4");
    list2.append("6");
    list2.append("7");
    list2.append("10");
//    System.out.println("list 2 =>>>"+list2);
    LinkedList zip=new LinkedList();

//    System.out.println(zip.zipLists(list1,list2));

    LinkedList linkedList1=new LinkedList();
    System.out.println(linkedList1.LinkedListReverser(list1));

    System.out.println(list1);
    list1.reverser();
    System.out.println(list1);
    System.out.println("=================================================================================");
    System.out.println("=================================================================================");
    LinkedList palindromeList = new LinkedList();
    palindromeList.append("1");
    palindromeList.append("2");
    palindromeList.append("3");
    palindromeList.append("4");
    palindromeList.append("3");
    palindromeList.append("2");
    palindromeList.append("1");
    palindromeList.append("4");
    System.out.println(palindromeList);
//    System.out.println(palindromeList.isPalindrome());
    System.out.println(isListPalindrome(palindromeList));
    System.out.println(palindromeList);
    System.out.println(isTextInList(palindromeList,"fox"));
    System.out.println(isTextInList(palindromeList,"4"));
  }

}
