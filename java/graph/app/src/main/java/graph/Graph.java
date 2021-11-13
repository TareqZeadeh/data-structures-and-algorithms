package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
  private Map<T, GraphNode<T>> nodes = new HashMap<>();
  private Map<GraphNode<T>, List<GraphNode<T>>> adjList = new HashMap<>();
  int size = 0;

  public GraphNode<T> addNode(T data) {
    int nodesSize=nodes.size();
    GraphNode<T> node = new GraphNode<>(data);
    nodes.putIfAbsent(data, node);
    adjList.putIfAbsent(node, new ArrayList<>());
    if(nodesSize != nodes.size())
    size++;
    return node;

  }

  public void addEdge(T from, T to) {
    GraphNode<T> fromNode = nodes.get(from);
    GraphNode<T> toNode = nodes.get(to);
    if (fromNode == null) {
      throw new IllegalArgumentException();
    }
    if (toNode == null) {
      throw new IllegalArgumentException();
    }

    if(fromNode == toNode ){
      adjList.get(fromNode).add(toNode);
    }
    else if (!adjList.get(fromNode).contains(toNode) && !adjList.get(toNode).contains(fromNode)) {
      adjList.get(fromNode).add(toNode);
      adjList.get(toNode).add(fromNode);
    }
  }


  public List<GraphNode<T>> getNodes(){
    List<GraphNode<T>> nodesList = new ArrayList<>(nodes.values());
    if(nodesList.isEmpty())
      return null;
    return nodesList;
  }

  public List<GraphNode<T>> getNeighbors(T data){
    GraphNode<T> recNode = nodes.get(data);
    return adjList.get(recNode);
  }

  public int size() {
    return size;
  }
}
