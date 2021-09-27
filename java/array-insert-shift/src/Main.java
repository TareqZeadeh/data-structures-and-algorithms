public class Main {
  public static void main(String[] args) {
    int[] array={2,4,6,-8};
    int value=5;
    int[] newArr = insertShiftArray(array , value );
    for (int i=0; i < newArr.length; i++){
      System.out.print(newArr[i]+ " ,");
    }


  }

  public static int[] insertShiftArray(int[] arr,int value){

      int midIndex= (int) Math.ceil((double)(arr.length)/2);

      int[] addValueNewArray= new int[arr.length+1];
       addValueNewArray[midIndex]=value;

      for (int i=0; i < addValueNewArray.length; i++){
        if(i < midIndex) {
          addValueNewArray[i] = arr[i];
        }
        else if(i > midIndex){
          addValueNewArray[i]=arr[i-1];
        }
      }

      return addValueNewArray ;
  }
}
