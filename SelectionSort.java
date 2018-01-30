import java.util.Scanner;
class SelectionSort {
  public static void main (String args[]){
    Scanner s = new Scanner (System.in);
    int[] array = new int [5];
    for (int i=0; i<array.length; i++){
      array[i]=s.nextInt();
    }
    
    int min, temp;
    for (int i=0; i<array.length; i++){
      min = i;
      for (int j=i+1; j<array.length; j++){
        if (array[j]<array[min]){
          min = j;
        }
      }
      temp = array[i];
      array[i] = array[min];
      array[min] = temp;
    }
    
    for (int i=0; i<array.length; i++){
      System.out.println(array[i]);
    }
  }
}
    