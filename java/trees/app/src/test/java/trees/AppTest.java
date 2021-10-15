/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package trees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
  void instantiateAnEmptyTree(){
      BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
      assertTrue(binarySearchTree.isEmpty(),"Should return true because the tree is empty");
    }
    @Test
  void  instantiateATreeWithASingleRootNode(){
      BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
      binarySearchTree.add("A");
      assertTrue(binarySearchTree.contains("A"),"should return true because the tree have only the root and it's value (A) ");
    }
    @Test
  void addALeftChildAndRightChildToASingleRootNode(){
      BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
      binarySearchTree.add("40");
      binarySearchTree.add("50");
      binarySearchTree.add("30");
      assertTrue(binarySearchTree.contains("50"),"should return true because the right side of the tree root value is (50)");
      assertTrue(binarySearchTree.contains("30"),"should return true because the left side of the tree root value is (30)");
    }
}
