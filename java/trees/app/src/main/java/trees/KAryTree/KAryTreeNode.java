package trees.KAryTree;


import java.util.ArrayList;
import java.util.List;

public class KAryTreeNode<T> {
  private T key;
  private  int K;
  private List<KAryTreeNode<T>> children = new ArrayList<>();

  public KAryTreeNode(T key, int k) {
    this.key = key;
    this.K = k;
  }

  public KAryTreeNode<T> addChild(T key) {
    KAryTreeNode<T> newNode = new KAryTreeNode<T>(key, K);
    if (children.size() < K) {
      children.add(newNode);
      return newNode;
    }

    return null;
  }

  public List<KAryTreeNode<T>> getChildren() {
    return children;
  }

  public KAryTreeNode<T> getChild(int index) {
    if (children.size() > index && index >= 0) {
      return children.get(index);
    }

    return null;
  }

  public T getKey() {
    return key;
  }

  public void setKey(T key) {
    this.key = key;
  }
}
