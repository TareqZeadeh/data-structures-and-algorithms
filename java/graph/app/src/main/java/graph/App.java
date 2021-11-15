/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package graph;

import java.util.ArrayList;
import java.util.List;

public class App {



    public static void main(String[] args) {

      Graph<String,Integer> graph = new Graph<>();
      graph.addNode("Tareq");
      graph.addNode("osaid");
      graph.addNode("mohammed");
      graph.addNode("rahaf");
//      graph.addNode("doaa");
//      graph.addNode("doaa");
//      graph.addNode("T");
//      graph.addNode("A");
      graph.addEdge("Tareq","osaid",10);
      graph.addEdge("Tareq","mohammed",20);
      graph.addEdge("Tareq","rahaf",30);
      graph.addEdge("mohammed","osaid",25);
      graph.addEdge("mohammed","rahaf",45);
      graph.addEdge("osaid","rahaf",35);
//      graph.addEdge("T","A");
////      graph.addEdge("T","T");
//      graph.addEdge("Tareq","mohammed");
//      System.out.println(graph.getNeighbors("T"));
//      System.out.println(graph.getNodes());
//      System.out.println(graph.size());
//      System.out.println(graph.breadthFirst("T"));
//      System.out.println(graph.breadthFirst("Tareq"));
//      System.out.println(graph.breadthFirst("mohammed"));
//      System.out.println(graph.breadthFirst("rahaf"));
    List<String> cities = new ArrayList<>();
    cities.add("Tareq");
    cities.add("mohammed");
    cities.add("rahaf");
    cities.add("osaid");
    cities.add("Tareq");
      System.out.println(Graph.businessTrip(graph,cities));
    }
}
