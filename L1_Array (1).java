/* 
 * Name: William Chen
 * Date: February 8 2017
 * Mr. Anandarajan
 * ICS4U Period 5
 * Objectives: Complete Level 1 Array Exercises
 */
import java.util.Scanner;

class L1_Array{
  static Scanner myScanner = new Scanner(System.in);
  static final int MAX = 10;
  public static void main (String args[]){
    int i=0;
    int[] numArray = new int[MAX];
    InitializeArray(numArray);
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
      System.out.println("Enter 12 to find the mean, ");
      System.out.println("Enter 13 to find the median, ");
      System.out.println("Enter 14 to selection sort ascending, ");
      System.out.println("Enter 15 to insertion sort ascending, ");
      System.out.println("Enter 16 to insertion sort descending, ");
      
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
      }else if (userInput==12){
        Mean(numArray);
      }else if (userInput==13){
        Median(numArray);
      }else if (userInput==14){
        Selection_Sort_Ascending(numArray);
        Selection_Sort_Descending(numArray);
      }else if (userInput==15){
        Insertion_Sort_Ascending(numArray);
      }else if (userInput==16){
        Insertion_Sort_Descending(numArray);
      }
      System.out.println("Enter 1 to use another method");
      System.out.println("Enter -1 to exit");
      userInput = myScanner.nextInt();
      if (userInput==-1){
        i = -1;
      }
    }while (i!=-1);
  }
  public static void InitializeArray (int[] array1){//set all values as -1 using for loop
    for (int i=0; i<array1.length; i++){
      array1[i] = (-1);
    }
  }
  public static void EnterFromKeyboard (int[] array2){//manually set values in loop
    for (int i=0; i<array2.length; i++){
      System.out.println("Enter number "+(i+1)+" of the array:");
      array2[i] = myScanner.nextInt();
    }
  }
  public static void CountWhole (int[] array3){
    int counter=0;
    for (int i=0; i<array3.length; i++){
      if (array3[i]>-1){// whole numbers are numbers that are positive (0 included)
        counter++;
      }
    }
    System.out.println("The number of whole numbers in this array is: "+counter);
  }
  public static void Display (int[] array4){// use for loop to show all values in array
    for (int i=0; i<array4.length; i++){
      System.out.println(array4[i]);
    }
  }
  public static void DisplayReverse (int[] array5){
     for (int i=0; i<array5.length/2; i++){// use for loop and temp variable to reverse the order of the array
       int temp = array5[i];
       array5[i] = array5[array5.length-i-1];
       array5[array5.length-i-1] = temp;
     }
     System.out.println("The integers in reverse order is ");
     for (int i=0; i<array5.length; i++){// use for loop to display all values in array
       System.out.print(array5[i]);
     }
     System.out.println();    
  }
  public static int Sum (int[] array6){
    int sum = 0;
    for (int i=0; i<array6.length; i++){// use for loop to accumulate all values in array
      sum+=array6[i];
    }
    return sum;
  }
  public static void Average (int[] array7){
    int sum = Sum(array7);// use sum method and divide by array.length to find average
    double roundedAverage = (double)sum/array7.length;
    System.out.println(roundedAverage);
  }
  public static void FindMax (int[] array8){
    int max=array8[0];// set max value as 0 and replace it with any higher values encountered in the array
    for (int i=0; i<array8.length; i++){
      if (max<array8[i]){
        max = array8[i];
      }
    }
    System.out.println(max);
  }
   public static void FindMin (int[] array9){
    int min=array9[0];// set min value as 0 and replace it with any lower values encountered in the array
    for (int i=0; i<array9.length; i++){
      if (min>array9[i]){
        min = array9[i];
      }
    }
    System.out.println(min);
  }
   public static void Search (int[] array10){
     System.out.println("Enter the number you want to search: ");
     int searchNum = myScanner.nextInt();
     System.out.println("The number "+searchNum+" is found in the following positions: ");
     for (int i=0; i<array10.length; i++){// if the search number shows up in the array, output the position of that value
       if (searchNum==array10[i]){
         System.out.print(i+", ");
       }
     }
     System.out.println();
   }
   public static void Sort (int[] list){
     boolean swap; 
     int j=1; // used to reduce number of loops
     int temp; 
     do{//use efficient bubble sort 
       swap = false;
       for (int i=0; i<list.length-j; i++){
         if (list[i]>list[i+1]){
           temp=list[i];
           list[i]=list[i+1];
           list[i+1]=temp;
           swap=true;
         }
       }
       j++;
     }while (swap==true);
   }
   public static void Mean (int[] array11){
     Average(array11);
   }
   public static void Median (int[] array12){
     Sort(array12);
     double median = 0;
     if (array12.length%2==0){// if number of values is even, find the average between the two middle values after sorting
       int[] medianAverages = {array12[array12.length/2], array12[(array12.length/2)-1]};
       median = (double)(Sum(medianAverages))/2;
     }else if(array12.length%2!=0){// if number of values is odd, middle number is the median upon sorting
       median = array12[array12.length/2];
     }
     System.out.println("The median is: "+median);
   }
   public static void Selection_Sort_Ascending (int[] array){
     int temp, min;
     for (int i=0; i<array.length; i++){
       min = i;
       for (int j=i+1; j<array.length; j++){
         if (array[j]<array[min]){
           min = j;
         }
       }
       temp = array[min];
       array[min] = array[i];
       array[i] = temp;
     }
     Display(array);
   }
   
   public static void Selection_Sort_Descending (int[] array){
     int max, temp;
     for (int i=0; i<array.length; i++){
       max = i;
       for (int j=i+1; j<array.length; j++){
         if (array[j]>array[max]){
           max = j;
         }
       }
       temp = array[max];
       array[max] = array[i];
       array[i] = temp;
     }
     Display(array);
   }
  
   
   public static void Insertion_Sort_Ascending (int[] list){
     int hold;
     int j;
     for (int i=1; i<list.length; i++){
       hold = list[i];
       j = i;
       while (j>0&&list[j-1]>hold){
         list[j] = list[j-1];
         j--;
       }
       list[j] = hold;
     }
     Display(list);
   }
   public static void Insertion_Sort_Descending (int[] list){
    int hold;
     int j;
     for (int i=1; i<list.length; i++){
       hold = list[i];
       j = i;
       while (j>0&&list[j-1]<hold){
         list[j] = list[j-1];
         j--;
       }
       list[j] = hold;
     }
     Display(list);
   }
}