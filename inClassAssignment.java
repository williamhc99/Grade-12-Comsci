/* 
 * Name: William Chen
 * Date: February 9 2017
 * Mr. Anandarajan
 * ICS4U Period 5
 * Objectives: Write a method that finds the minimum value and returns it to the main method
 */
import java.util.Scanner;
class inClassAssignment{
  public static void main (String args[]){
    Scanner myScanner = new Scanner(System.in);
    final int MAX = 10;
    int[] numArray = new int[MAX];
    for (int i =0; i<numArray.length; i++){
      System.out.println("Enter number "+i+" of the array:");
      numArray[i]=myScanner.nextInt();
    }
    int minNumber = FindMin(numArray);
    System.out.println("The min number in the array is: "+minNumber);
  }
  public static int FindMin (int [] array1){  
    int min=array1[0];
    for (int i=0; i<array1.length-1; i++){
      if (min>array1[i+1]){
        min = array1[i+1];
      }
    }
    return min;
  }
}