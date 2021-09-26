public class ReverseArray {
  public static void main(String[] args){
  int[] numberList={89, 2354, 3546, 23, 10, -923, 823, -12};
  int[] ReverseList = reverseArray(numberList);
  for(int i=0 ; i<ReverseList.length ; i++){
    System.out.print(" "+ReverseList[i]);
  }
  }

  public static int[] reverseArray(int[] arr){

    int[] reveredArr=new int[arr.length];
    for (int i=0 ; i<arr.length ; i++){
      reveredArr[i]=arr[arr.length-1-i];
    }

    return reveredArr;
  }
}
