/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hashTable;

import java.util.*;
import java.util.Map.Entry;

public class App {

  public static String repeatedWord(String string) {
    if(string == ""){
      System.out.println("The input is Empty String");
      return null;
    }
    String str = string.toLowerCase(Locale.ROOT);
    String strArray[] = str.split("[\\p{Punct}\\s]+");
    Map<String, Integer> strMap = new LinkedHashMap<>();
    for (int i = 0; i < strArray.length; i++) {
      if (strMap.containsKey(strArray[i])) {
        strMap.put(strArray[i], strMap.get(strArray[i]) + 1);
      } else {
        strMap.put(strArray[i], 1);
      }
    }
    for (Entry<String, Integer> entry : strMap.entrySet()) {
      if (entry.getValue() >= 2) {
        return entry.getKey();
      }
    }
    return null;
  }
  //=================================challenge 32================================

  public static List<Integer> treeIntersection(BinaryTree<Integer> tree1,BinaryTree<Integer> tree2){
    if(tree1.root == null && tree2.root == null){return new ArrayList<>();}
    else if(tree1.root != null && tree2.root == null){return new ArrayList<>();}
    else if(tree1.root == null && tree2.root != null){return new ArrayList<>();}
    HashTable<Integer,Integer> table = new HashTable<>();
    List<Integer> common = new ArrayList<>();
    for (int item : tree1.preOrder(tree1.root)){
      table.add(item,0);
    }
    List<Integer> list = tree2.inOrder(tree2.root);
    for(int item : list){
      if(table.contain(item)){common.add(list.get(list.indexOf(item)));}
      else{table.add(list.get(list.indexOf(item)),0);}
    }
    return common;
  }

  //=================================challenge 33================================

  public static List<List<String>> leftJoin(HashTable<String , String> table1 , HashTable<String , String> table2){
    List<List<String>> dictionary = new ArrayList<>();
    for (int i = 0; i < table1.getBucketSize(); i++) {
      List<String> data = new ArrayList<>();
      if(table1.getBucketArray().get(i) != null ){
        data.add(table1.getBucketArray().get(i).key);
        data.add(table1.getBucketArray().get(i).value);
        data.add(table2.get(data.get(0)));
        dictionary.add(data);

      }

    }
    return dictionary;
  }

  //=================================challenge 34================================

  public static boolean isStringUnique(String string){
    HashMap<Character,Integer> stringChars = new HashMap<>();
    String str = string.toLowerCase(Locale.ROOT);
    for(char ch : str.toCharArray()){
      if(ch != ' '){
        if(stringChars.containsKey(ch)){
          return false;
        }
        else
          stringChars.put(ch, 1);
      }
    }
    return true;
  }


  public static void main(String[] args) {
    HashTable<String, Integer> hashTable = new HashTable<>();
    hashTable.add("Tareq", 50);
    hashTable.add("Mohammed", 60);
    hashTable.add("Hatem", 40);
//      hashTable.add("Oside",55);
//      hashTable.add("Rahaf",45);
//      hashTable.add("Doaa",65);
//      hashTable.add("Anas",46);
    hashTable.add("Teheran", 46);
    hashTable.add("Siblings", 47);
    System.out.println(hashTable);
    System.out.println("++++==============================+++++");
    System.out.println("++++==============================+++++");
    System.out.println(hashTable.get("Tareq"));
    System.out.println(hashTable.get("Mohammed"));
    System.out.println(hashTable.get("Omar"));
    System.out.println("++++==============================+++++");
    System.out.println("++++==============================+++++");
    System.out.println(hashTable.contain("Anas"));
    System.out.println(hashTable.contain("Omar"));
    System.out.println("++++==============================+++++");
    System.out.println("++++==============================+++++");
    System.out.println(hashTable.getBucketIndex("Tareq"));
    System.out.println(hashTable.getBucketIndex("Teheran"));
    System.out.println(hashTable.getBucketIndex("Siblings"));

    String str = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way – in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only...";
    System.out.println(repeatedWord(str));



//=================================challenge 32================================

    BinaryTree<Integer> tree1 = new BinaryTree<>();
    BinaryTree<Integer> tree2 = new BinaryTree<>();

    tree1.root = new BinaryNode<>(10);
    tree1.root.left = new BinaryNode<>(20);
    tree1.root.right = new BinaryNode<>(25);
    tree1.root.right.right = new BinaryNode<>(40);
    tree1.root.right.left = new BinaryNode<>(50);


    tree2.root = new BinaryNode<Integer>(15);
    tree2.root.left = new BinaryNode<>(20);
    tree2.root.right = new BinaryNode<>(25);
    tree2.root.right.right = new BinaryNode<>(40);
    tree2.root.right.left = new BinaryNode<>(55);


    System.out.println(treeIntersection(tree1,tree2));


    //=================================challenge 33================================

    HashTable<String,String> table1 = new HashTable<>();
    HashTable<String,String> table2 = new HashTable<>();

    table1.add("outift", "garb");
    table1.add("fond", "enamored");
    table1.add("wrath", "anger");
    table1.add("diligent", "employed");
    table1.add("guide", "usher");

    table1.add("b", "2");
    table1.add("c", "3");

    table2.add("fond", "averse");
    table2.add("wrath", "delight");
    table2.add("diligent", "idle");
    table2.add("guide", "follow");
    table2.add("flow", "jam");
    table2.add("flow2", "jam");
    System.out.println(leftJoin(table1,table2));

    //=================================challenge 34================================
    String st = "Donald the duck";
    System.out.println(isStringUnique(st));
  }
}
