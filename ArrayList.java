/* 
 * Name: William Chen
 * Date: February 8 2017
 * Mr. Anandarajan
 * ICS4U Period 5
 * Objectives: Complete Level 1 Array Exercises
 */
import java.util.ArrayList;
import java.util.Scanner;

class ArrayList_Ex{
  static Scanner myScanner = new Scanner(System.in);
  static final int MAX = 10;
  public static void main (String args[]){
    int i=0;
    ArrayList <Integer> numArray = new ArrayList <Integer> ();
    EnterFromKeyboard(numArray);
    do{// menu loop
      System.out.println("Enter 3 to CountWhole, ");
      System.out.println("Enter 4 to Display, ");
      System.out.println("Enter 5 to DisplayReverse, ");
      System.out.println("Enter 6 to calculate Sum, ");
      System.out.println("Enter 7 to calculate Average, ");
      System.out.println("Enter 8 to FindMax, ");
      System.out.println("Enter 9 to FindMin, ");
      System.out.println("Enter 10 to Search, ");
      System.out.println("Enter 11 to Sort the array, ");
      int userInput = myScanner.nextInt();
      if (userInput==3){
        CountWhole(numArray);
      }else if (userInput==4){
        Display(numArray);
      }else if (userInput==5){
        DisplayReverse(numArray);
      }else if (userInput==6){
        int sum = Sum(numArray);
        System.out.println("The sum of all the numbers entered is: "+sum);
      }else if (userInput==7){
        Average(numArray);
      }else if (userInput==8){
        FindMax(numArray);
      }else if (userInput==9){
        FindMin(numArray);
      }else if (userInput==10){
        Search(numArray);
      }else if (userInput==11){
        Sort(numArray);
      }
      System.out.println("Enter 1 to use another method");
      System.out.println("Enter -1 to exit");
      userInput = myScanner.nextInt();
      if (userInput==-1){
        i = -1;
      }
    }while (i!=-1);
  }
  public static void EnterFromKeyboard (ArrayList <Integer> list){//manually set values in loop
    for (int i=0; i<MAX; i++){
      System.out.println("Enter number "+(i+1)+" of the array:");
      list.add(myScanner.nextInt());
    }
  }
  public static void CountWhole (ArrayList <Integer> list){
    int counter=0;
    for (int i=0; i<list.size(); i++){
      if (list.get(i)>-1){// whole numbers are numbers that are positive (0 included)
        counter++;
      }
    }
    System.out.println("The number of whole numbers in this array is: "+counter);
  }
  public static void Display (ArrayList list){// use for loop to show all values in array
    for (int i=0; i<MAX; i++){
      System.out.println(list.get(i));
    }
  }
  public static void DisplayReverse (ArrayList list){
     for (int i=MAX-1; i>0; i--){// use for loop and temp variable to reverse the order of the array
       System.out.println(list.get(i));
     }
  }
  public static int Sum (ArrayList <Integer> list){
    int sum = 0;
    for (int i=0; i<list.size(); i++){// use for loop to accumulate all values in array
      sum+=list.get(i);
    }
    return sum;
  }
  public static void Average (ArrayList list){
    int sum = Sum(list);// use sum method and divide by array.length to find average
    double roundedAverage = (double)sum/list.size();
    System.out.println(roundedAverage);
  }
  public static void FindMax (ArrayList <Integer> list){
    int max=list.get(0);// set max value as 0 and replace it with any higher values encountered in the array
    for (int i=1; i<list.size(); i++){
      if (max<list.get(i)){
        max=list.get(i);
      }
    }
    System.out.println(max);
  }
   public static void FindMin (ArrayList <Integer> list){
    int min=list.get(0);// set min value as 0 and replace it with any lower values encountered in the array
    for (int i=1; i<list.size(); i++){
      if (min>list.get(i)){
        min=list.get(i);
      }
    }
    System.out.println(min);
  }
   public static void Search (ArrayList <Integer> list){
     System.out.println("Enter the number you want to search: ");
     Integer searchNum = myScanner.nextInt();
     if (list.contains(searchNum)==true){
       System.out.println("The number "+searchNum+" is found in the following positions: ");
       for (int i=0; i<list.size(); i++){// if the search number shows up in the array, output the position of that value
         if (searchNum==list.get(i)){
           System.out.print(i+", ");
         }
       }
       System.out.println();
     }else if (list.contains(searchNum)==false){
       System.out.println("The number "+searchNum+" is not found in the array");
     }
   }
   public static void Sort (ArrayList <Integer> list){
     boolean swap; 
     int j=1; // used to reduce number of loops
     int temp; 
     do{//use efficient bubble sort 
       swap = false;
       for (int i=0; i<list.size()-j; i++){
         if (list.get(i)>list.get(i+1)){
           temp=list.get(i);
           list.set(i, list.get(i+1));
           list.set(i+1, temp);
           swap=true;
         }
       }
       j++;
     }while (swap==true);
   }
}