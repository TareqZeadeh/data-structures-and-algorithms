package graph;

import java.util.HashMap;

public class GraphNode <T,W>{
  private T data;
  private HashMap<T,W> weight;

  public GraphNode(T data) {
    this.data = data;
    weight = new HashMap<>();
  }

  public T getData() {
    return data;
  }

  public HashMap<T, W> getWeight() {
    return weight;
  }

  public void setWeight(HashMap<T, W> weight) {
    this.weight = weight;
  }


  @Override
  public String toString() {
    return data.toString();
  }
}
