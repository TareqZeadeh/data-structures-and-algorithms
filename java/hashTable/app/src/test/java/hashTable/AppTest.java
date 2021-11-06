/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hashTable;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

  @Test
  void valueBeingInTheDataStructure (){
    HashTable<String,Integer> hashTable = new HashTable<>();
    hashTable.add("A",7);
    assertTrue(hashTable.contain("A"));
    assertEquals(7,hashTable.get("A"));
  }

  @Test
  void retrievingBasedOnAKeyReturnsTheValueStored(){
    HashTable<String,Integer> hashTable = new HashTable<>();
    hashTable.add("A",7);
    assertEquals(7,hashTable.get("A"));
  }

  @Test
  void  returnsNullForAKeyThatDoesNotExistInTheHashtable(){
    HashTable<String,Integer> hashTable = new HashTable<>();
    hashTable.add("A",7);
    assertNull(hashTable.get("B"));
  }


  @Test
  void successfullyHandleACollisionWithinTheHashtable(){
    HashTable<String,Integer> hashTable = new HashTable<>();
    hashTable.add("Teheran",46);
    hashTable.add("Siblings",47);
    HashNode<String,Integer> node ;
    node = hashTable.getBucketArray().get(hashTable.getBucketIndex("Teheran"));
    assertTrue(node.hashCode == node.getNext().hashCode);
  }


  @Test
  void retrieveAValueFromABucketWithinTheHashtableThatHasACollision(){
    HashTable<String,Integer> hashTable = new HashTable<>();
    hashTable.add("Teheran",46);
    hashTable.add("Siblings",47);
    assertEquals(47,hashTable.get("Siblings"));
  }

  @Test
  void indexInRang(){
    HashTable<String, Integer> hashTable = new HashTable<>();

    try {
      hashTable.add("Tariq", 100);
      hashTable.add("Teheran", 75);
      hashTable.add("Siblings", 120);
      System.out.println(hashTable);
      int hashCode = hashTable.hashCode("Tariq");
      int index = hashCode % hashTable.getSize();
      assertTrue(0 <= index && index <= hashTable.getSize());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}