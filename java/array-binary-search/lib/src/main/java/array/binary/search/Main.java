package array.binary.search;

public class Main {
  public static void main(String[] args) {
    int[] arr = {-131, -82, 0, 27, 42, 68, 179};
    int value = 42;
    int index = Library.BinarySearch(arr, value);
    System.out.println(index);
  }
}
