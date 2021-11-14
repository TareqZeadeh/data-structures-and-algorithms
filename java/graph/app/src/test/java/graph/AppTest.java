/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void  successfullyAddedNode() {
      Graph<String> graph = new Graph<>();
      graph.addNode("T");
      assertEquals(1,graph.size());

    }
    @Test void  successfullyAddedEdge (){
      Graph<String> graph = new Graph<>();
      graph.addNode("T");
      graph.addNode("A");
      graph.addEdge("T","A");
      assertEquals("[A]",graph.getNeighbors("T").toString());
    }
    @Test void nodesCanBeProperlyRetrievedFromTheGraph(){
      Graph<String> graph = new Graph<>();
      graph.addNode("T");
      graph.addNode("A");
      assertNotNull(graph.getNodes());
    }
  @Test void onlyOneNodeAndEdgeCanBeProperlyReturned(){
    Graph<String> graph = new Graph<>();
    graph.addNode("T");
    graph.addEdge("T","T");
    assertNotNull(graph.getNodes());
    assertEquals("[T]",graph.getNeighbors("T").toString());
  }
  @Test void sizeIsReturned (){
    Graph<String> graph = new Graph<>();
    graph.addNode("T");
    graph.addNode("A");
    assertEquals(2,graph.size());
  }
  @Test void emptyGraphProperlyReturnsNull(){
    Graph<String> graph = new Graph<>();
    assertNull(graph.getNodes());
  }
  //===========================challenge 36============================

  @Test void notExistedNodeInTheGraph(){
    Graph<String> graph = new Graph<>();
    graph.addNode("T");
    graph.addNode("A");
    graph.addEdge("T","A");
    assertNull(graph.breadthFirst("G"));
    }
  @Test void existedNodeInTheGraph(){
    Graph<String> graph = new Graph<>();
    graph.addNode("T");
    graph.addNode("A");
    graph.addEdge("T","A");

    assertEquals("[T, A]",graph.breadthFirst("T").toString());
  }
}
