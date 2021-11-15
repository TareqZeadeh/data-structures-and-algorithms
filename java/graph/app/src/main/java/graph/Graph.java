package graph;

import java.util.*;

public class Graph<T,W> {
  private Map<T, GraphNode<T,W>> nodes = new HashMap<>();
  private Map<GraphNode<T,W>, List<GraphNode<T,W>>> adjList = new HashMap<>();
  int size = 0;

  public GraphNode<T,W> addNode(T data) {
    int nodesSize=nodes.size();
    GraphNode<T,W> node = new GraphNode<>(data);
    nodes.putIfAbsent(data, node);
    adjList.putIfAbsent(node, new ArrayList<>());
    if(nodesSize != nodes.size())
    size++;
    return node;

  }

  public void addEdge(T from, T to) {
    GraphNode<T,W> fromNode = nodes.get(from);
    GraphNode<T,W> toNode = nodes.get(to);
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
  public void addEdge(T from, T to , W weight) {
    GraphNode<T,W> fromNode = nodes.get(from);
    GraphNode<T,W> toNode = nodes.get(to);
    if (fromNode == null) {
      throw new IllegalArgumentException();
    }
    if (toNode == null) {
      throw new IllegalArgumentException();
    }

    if(fromNode == toNode ){
      adjList.get(fromNode).add(toNode);
      fromNode.getWeight().put(to,weight);
    }
    else if (!adjList.get(fromNode).contains(toNode) && !adjList.get(toNode).contains(fromNode)) {
      adjList.get(fromNode).add(toNode);
      adjList.get(toNode).add(fromNode);
      fromNode.getWeight().put(to,weight);
      toNode.getWeight().put(from,weight);
    }
  }


  public List<GraphNode<T,W>> getNodes(){
    List<GraphNode<T,W>> nodesList = new ArrayList<>(nodes.values());
    if(nodesList.isEmpty())
      return null;
    return nodesList;
  }

  public List<GraphNode<T,W>> getNeighbors(T data){
    GraphNode<T,W> recNode = nodes.get(data);
    return adjList.get(recNode);
  }

  public int size() {
    return size;
  }

  public List<GraphNode<T,W>> breadthFirst(T data){
    GraphNode<T,W> node = nodes.get(data);
    if(node == null)
      return null;
    List<GraphNode<T,W>> nodesList = new ArrayList<>();
    Set<GraphNode<T,W>> visited = new HashSet<>();
    Queue<GraphNode<T,W>> queue = new ArrayDeque<>();
    queue.add(node);
    while (!queue.isEmpty()){
      GraphNode<T,W> current = queue.remove();
      if(visited.contains(current))
        continue;
      nodesList.add(current);
      visited.add(current);
      for (GraphNode<T,W> neighbour : adjList.get(current)){
        if(!visited.contains(neighbour))
          queue.add(neighbour);
      }

    }
    return nodesList;
  }
  public static String businessTrip(Graph<String,Integer> graph, List<String> cities){
    if(graph.size() == 0) return "The Graph Is Empty";
    if(cities.size() == 0) return "The Cities List Is Empty";
    if(graph.size() == 0 && cities.size() == 0) return "The Graph And The List Is Empty";
    Integer cost = 0;
    for (int i = 0; i<cities.size()-1;i++){
      GraphNode<String,Integer> currentNode = graph.getSpecificNode(cities.get(i));
      GraphNode<String,Integer> nextNode = graph.getSpecificNode(cities.get(i+1));
      if(graph.getNeighbors(currentNode.getData()).contains(nextNode)){
        cost = cost + getEdgeWeight(currentNode,nextNode);
      }
      else{
        return "False, $0";
      }
    }
    return "True, $"+cost;
  }
  public static Integer getEdgeWeight(GraphNode<String,Integer> current,GraphNode<String,Integer> next){
    return current.getWeight().get(next.getData());
  }
  private GraphNode<T,W> getSpecificNode(T data){
    return nodes.get(data);
  }
}
