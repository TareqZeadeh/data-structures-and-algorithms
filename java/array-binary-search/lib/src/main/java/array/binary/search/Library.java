/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package array.binary.search;

public class Library {
    public boolean someLibraryMethod() {
        return true;
    }

  public static int BinarySearch(int[] list, int key) {
    int right = list.length - 1;
    int left = 0;
    int mid;
    while (left <= right) {
      mid = (left + right) / 2;
      if (key == list[mid]) {
        return mid;
      } else if (key > list[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
