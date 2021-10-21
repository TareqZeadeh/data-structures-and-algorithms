package trees.KAryTree;

import java.util.ArrayList;
import java.util.List;

public class KAryTree<T> {

  private KAryTreeNode<T> root;
  private int height;
  private int index = 0;
  private final List<KAryTreeNode<T>> KArayTreeNodes = new ArrayList<>();

  public KAryTree(List<T> values, int K){
    height = (int)Math.ceil((Math.log((double)values.size() * (K - 1)) / Math.log(K)) - 1) + 1;
    System.out.println(height);
    int arrayLength = values.size();

    if (arrayLength <= 0) {
      return;
    }
    root = new KAryTreeNode<>(values.get(0),K);
    KArayTreeNodes.add(root);
    createKAryTree(values, K, root);
  }

  private void createKAryTree(List<T> values, int K, KAryTreeNode<T> node){
    for (int j = 0; j < K; j++) {
      if ((K * index + (j + 1)) > (values.size() - 1)){
        return;
      }else {
        KArayTreeNodes.add(node.addChild(values.get(K * index + (j + 1))));
      }
    }
    if (index < values.size()) {
      index++;
      createKAryTree(values, K, KArayTreeNodes.get(index));
    }
  }
  // Function to print postorder traversal of the tree
  public void postorder(KAryTreeNode<T> root) {
    if (root == null) {
      return;
    }
    for (int i = 0; i < root.getChildren().size(); i++) {
      postorder(root.getChildren().get(i));
    }
    System.out.print(root.getKey() + " ");
  }

  public void treeFizzBuzz(){
    for (KAryTreeNode<T> kAryNode: KArayTreeNodes){
      if ((((Integer) kAryNode.getKey()) % 3 == 0) && (((Integer) kAryNode.getKey()) % 5 == 0)){
        kAryNode.setKey((T) "FizzBuzz");
      }else if(((Integer) kAryNode.getKey()) % 3 == 0){
        kAryNode.setKey((T) "Fizz");
      }else if(((Integer) kAryNode.getKey()) % 5 == 0){
        kAryNode.setKey((T) "Buzz");
      }
    }
  }
  public KAryTreeNode<T> getRoot() {
    return root;
  }

}
