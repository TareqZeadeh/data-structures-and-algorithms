/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Insertion.Sort;

import java.util.Arrays;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }
    public static int[] sort(int[] arr){
      for (int i=1; i<arr.length; i++){
        int temp =arr[i];
        int j=i-1;
        while (j>=0 && temp<arr[j]){
          arr[j+1] = arr[j];
          j = j-1;
        }
        arr[j+1]=temp;
      }
      return arr;
    }

    public static void mergeSort (int[] arr){
      int inputLength = arr.length;
      if (inputLength<2){return;}
      int midIndex = inputLength/2;
      int[] left = new int[midIndex];
      int[] right = new int[inputLength - midIndex];
      for(int i=0; i<midIndex;i++){left[i] = arr[i];}
      for (int i=midIndex;i<inputLength;i++){right[i-midIndex] = arr[i];}
      mergeSort(left);
      mergeSort(right);
      merge(arr,left,right);
    }
    public static void merge (int[] arr,int[] left,int[] right){
    int leftSize = left.length;
    int rightSize = right.length;
    int i = 0, j = 0, k = 0;
    while (i<leftSize && j<rightSize) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }
      while (i<leftSize){
        arr[k] = left[i];
        i++;k++;
      }
      while (j<rightSize){
        arr[k] = right[j];
        j++;k++;
      }

    }
    public static void main(String[] args) {
      int arr[] = {8,4,23,42,16,15};
//      System.out.println(Arrays.toString(sort(arr)));
       mergeSort(arr);
      System.out.print("[");
       for(int i=0; i<arr.length;i++){
         if(i==0){System.out.print(arr[i]);}
         else {System.out.print(", "+arr[i]);}
       }
      System.out.print("]");
    }
}
