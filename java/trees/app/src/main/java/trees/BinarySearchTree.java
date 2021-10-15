package trees;

public class BinarySearchTree<T extends Comparable<T>> {
  private BinaryNode<T> root;

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
}


