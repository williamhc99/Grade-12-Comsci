import java.util.Scanner;
class InsertionSort {
  public static void main (String args[]){
    Scanner s = new Scanner (System.in);
    int[] array = new int [5];
    for (int i=0; i<array.length; i++){
      array[i]=s.nextInt();
    }
    
    int hold,j;
    
    for (int i=0; i<array.length; i++){
      hold = array[i];
      j = i;
      while (j>0&&array[j-1]<hold){
        array[j] = array[j-1];
        j--;
      }
      array[j] = hold;
    }
    
    
    for (int i=0; i<array.length; i++){
      System.out.println(array[i]);
    }
  }
}