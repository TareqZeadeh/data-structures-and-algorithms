package hashTable;

public class HashNode<K, V> {
  K key;
  V value;
  int hashCode;
  HashNode<K,V> next;

  public HashNode(K key, V value, int hashCode) {
    this.key = key;
    this.value = value;
    this.hashCode = hashCode;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public int getHashCode() {
    return hashCode;
  }

  public void setHashCode(int hashCode) {
    this.hashCode = hashCode;
  }

  public HashNode<K, V> getNext() {
    return next;
  }

  public void setNext(HashNode<K, V> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "HashNode{" +
      "key=" + key +
      ", value=" + value +
      ", hashCode=" + hashCode +
      '}';
  }
}
