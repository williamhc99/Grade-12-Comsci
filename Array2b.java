/* 
 * Name: William Chen
 * Date: February 8 2017
 * Mr. Anandarajan
 * ICS4U Period 5
 * Objectives: Complete Level 2 Array Exercises Part B
 */

import java.util.Scanner;
class Array2b{
  static Scanner myScanner = new Scanner(System.in);
  public static void main (String[] args){
    int placeholder=0;
    countOccurrences(placeholder);
    countOccurrences2(placeholder);
    totals(placeholder);
    totals2(placeholder);
  }
  public static void countOccurrences(int placeholder) {
    int[] list = new int [10];
    System.out.println("Enter number: ");
    int userInput = myScanner.nextInt();
    while (userInput>0&&userInput<11){
      list[userInput-1]++;
      System.out.println("Enter number: ");
      userInput = myScanner.nextInt();
    }
    System.out.println("Number    |  Occurrences");
    for (int i=0; i<list.length; i++){
      System.out.println((i+1)+"         |          "+list[i]);
    }
  }
   public static void countOccurrences2(int placeholder) {
    int[] list = new int [10];
    System.out.println("Enter number: ");
    int userInput = myScanner.nextInt();
    while (userInput>14&&userInput<26){// adjusting requirements to make sure values are between 15 and 25
      list[userInput-15]++;
      System.out.println("Enter number: ");
      userInput = myScanner.nextInt();
    }
    System.out.println("Number     |  Occurrences");
    for (int i=0; i<list.length; i++){
      System.out.println((i+15)+"         |          "+list[i]);
    }
  }
   public static void totals (int placeholder){
    int [] sum = new int [10];
    System.out.println("Enter number: ");
    int userInput = myScanner.nextInt();
    int num = userInput/10;// java int does not calculate decimals so dividing userInput by 10 sorts variables into 10 categories based on their numerical size
    while (userInput>=0&&userInput<100){
      sum[num] = sum[num]+userInput;
      System.out.println("Enter number: ");
      userInput = myScanner.nextInt();
      num = userInput/10;
    }
    System.out.println("Section    |          Sum");
    for (int i=0; i<sum.length; i++){
      System.out.println((i*10)+"-"+((i*10)+9)+"         |          "+sum[i]);
    }
   }
   public static void totals2 (int placeholder){
     int [] sum = new int [10];
     System.out.println("Enter number: ");
     int userInput = myScanner.nextInt();
     int num = userInput/10;
     while (userInput>=0&&userInput<100){
       sum[num] = sum[num]+userInput;
       System.out.println("Enter number: ");
       userInput = myScanner.nextInt();
       num = userInput/10;
     }
     for (int i=1; i<sum.length; i++){// accumulate previous array index into current index and find total sums
       sum[i]+=sum[i-1];
     }
     System.out.println("Section    |    Total Sum");
     for (int i=0; i<sum.length; i++){
       System.out.println((i*10)+"-"+((i*10)+9)+"         |          "+sum[i]);
     }
   }
}