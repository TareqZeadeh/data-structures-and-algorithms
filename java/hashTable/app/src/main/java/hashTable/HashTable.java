package hashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HashTable<K, V> {
  private List<HashNode<K,V>> bucketArray;
  private int bucketSize;
  private int size;

  public HashTable() {
    bucketArray=new ArrayList<>();
    bucketSize = 10;
    size = 0;
    for (int i=0; i<bucketSize;i++){
      bucketArray.add(null);
    }
  }

  public List<HashNode<K, V>> getBucketArray() {
    return bucketArray;
  }

  public int getSize(){return size;}
  public boolean isEmpty(){return getSize() == 0;}

  public int hashCode(K key) {
    return Objects.hashCode(key);
  }

  public int getBucketIndex(K key){
    int hashCode = hashCode(key);
    int index = hashCode % bucketSize;
    index = index < 0 ? index * -1 : index;
    return index;
  }

  public void add (K key, V value) {
    int index = getBucketIndex(key);
    int hashCode = hashCode(key);

    HashNode<K, V> head = bucketArray.get(index);
    while (head != null) {
      if (head.key.equals(key) && head.hashCode == hashCode) {
        head.setValue(value);
        return;
      }
      head = head.getNext();
    }

    size++;
    head = bucketArray.get(index);
    HashNode<K, V> newNode = new HashNode<>(key, value, hashCode);
    newNode.setNext(head);
    bucketArray.set(index, newNode);

    if ((1.0 * size) / bucketSize >= 0.7) {
      List<HashNode<K, V>> temp = bucketArray;
      bucketArray = new ArrayList<>();
      bucketSize = 2 * bucketSize;
      size = 0;

      for (int i = 0; i < bucketSize; i++) {
        bucketArray.add(null);
      }

      for (HashNode<K, V> headNode : temp) {
        while (headNode != null) {
          add(headNode.key, headNode.value);
          headNode = headNode.next;
        }
      }
    }
  }


  public V get(K key) {
    int index = getBucketIndex(key);
    int hashCode = hashCode(key);
    HashNode<K, V> head = bucketArray.get(index);
    while (head != null) {
      if (head.key.equals(key) && head.getHashCode() == hashCode) {
        return head.value;
      }
      head = head.getNext();
    }
    return null;
  }


  public boolean contain(K key) {
    return get(key) != null;
  }

  @Override
  public String toString() {
    return "HashTable{" +
      "bucketArray=" + bucketArray +
      '}';
  }

  public int getBucketSize() {
    return bucketSize;
  }
}
