package graph;

public class GraphNode <T>{
  T data;

  public GraphNode(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  @Override
  public String toString() {
    return data.toString();
  }
}
