package trees;

import trees.Queue.Node;
import trees.Queue.Queue;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
  private BinaryNode<T> root;
  private int size;

  public Boolean isEmpty() {
    return root == null;
  }

  public void add(T data) {
    if (isEmpty()) {
      root = new BinaryNode<>(data);
    } else {
      addHelper(data, root);
    }
  }

  private void addHelper(T data, BinaryNode<T> root) {
    BinaryNode<T> binaryNode = new BinaryNode<>(data);
    if (data.compareTo(root.getData()) > 0) {
      if (root.getRightNode() == null) {
        root.setRightNode(binaryNode);
      } else {
        addHelper(data, root.getRightNode());
      }
    }
    else if (data.compareTo(root.getData()) < 0){
      if (root.getLeftNode() == null) {
        root.setLeftNode(binaryNode);
      } else {
        addHelper(data, root.getLeftNode());
      }
    }
    size++;
  }

  public Boolean contains(T data){
    if(isEmpty()){return false;}
    return contains(data, root);
  }

  private Boolean contains(T data, BinaryNode<T> root){
    if(root==null)
    return false;

    if(data.compareTo(root.getData())==0)
      return true;
    else if (data.compareTo(root.getData())>0) {return contains(data,root.getRightNode());}
    else {return contains(data,root.getLeftNode());}

  }

//==============================code 16 ====================================
  public T findMax() throws Exception{
    if(isEmpty()){throw new Exception("The tree is empty");}
    else {
      return findMax(root);
    }
  }
  private T findMax(BinaryNode<T> root){
    if (root.getRightNode() != null){
     return findMax(root.getRightNode());
    }else return root.getData();
  }

  //==============================code 17 ====================================

  public List<T> breadthFirst(BinarySearchTree<T> tree){
    if(root==null) {return null;}
    Queue<BinaryNode<T>>queue = new Queue<>();
    List<T> list = new ArrayList<>();
    queue.enqueue(root);
    list.add((T) root.getData());
    System.out.print("[");
    while (!queue.isEmpty()){
      try {
        BinaryNode<T> node = queue.dequeue();
        if(node.getLeftNode()!=null){
          queue.enqueue(node.getLeftNode());
          list.add((T) node.getLeftNode().getData());
        }if(node.getRightNode()!=null){
          queue.enqueue(node.getRightNode());
          list.add((T) node.getRightNode().getData());
        }
        System.out.print(node.getData() + ", ");
      }catch (Exception e){e.printStackTrace();}
    }
    System.out.print("]");
    return list;
  }
  //===============================================================================
  private int breadthFirstForCompare(BinarySearchTree<T> tree){
    int counter = 0;
    Queue<BinaryNode<T>>queue = new Queue<>();
    queue.enqueue(root);
    while (!queue.isEmpty()){
      try {
        BinaryNode<T> node = queue.dequeue();
        if(node.getLeftNode()==null && node.getRightNode()==null)
          counter++;
        if(node.getLeftNode()!=null){
          queue.enqueue(node.getLeftNode());
        }if(node.getRightNode()!=null){
          queue.enqueue(node.getRightNode());
        }

      }catch (Exception e){e.printStackTrace();}
    }
    return counter;
  }
  public Boolean ComparingTwoDirectories(BinarySearchTree<T> tree1 ,BinarySearchTree<T> tree2 ){
    int counter1=0;
    int counter2=0;
    if(tree1.root==null && tree2.root!=null) {
      System.out.println("First Tree is Empty");
      return false;}
    else if(tree1.root!=null && tree2.root==null) {
      System.out.println("Second Tree is Empty");
      return false;}
    else if(tree1.root==null && tree2.root==null) {
      System.out.println("Both Of Trees is Empty");
      return false;}
    else {
      counter1 = tree1.breadthFirstForCompare(tree1);
      counter2 = tree2.breadthFirstForCompare(tree2);
      if(counter1 == counter2)
        return true;
      else return false;
    }
  }

}


