/* Name: William Chen
 * Date: February 8 2017
 * Mr. Anandarajan
 * ICS4U Period 5
 * Objectives: Write a program that includes methods to output all factors, find the sum of all factors, find all perfect numbers
 * Efficiency:
 * This code can possibly be more efficient if:
 * 
 * 1. the sumOfFactors and outputFactors were combined somehow because they utilize the same loop just in different ways
 * 2. I utilized a more efficient method to find factors instead of just testing all the numbers
 * 3. a more efficient perfect number test formula was utilized instead of just testing all the numbers 
 */

import java.util.Scanner;
class Algorithim_and_EfficiencyTasks{
  public static void main (String args[]){
    Scanner myScanner = new Scanner (System.in);
    int userInput; // used to store user inputted number
    final int MAX = 500;
    int [] perfectNumbers = new int [500];// used to store perfect numbers between 1-500
    boolean perfectNumberBoolean; // used to check if number is a perfect number or not
    
    System.out.println("Enter a number: ");
    userInput = myScanner.nextInt();
    
    outputFactors(userInput);
   
    int sum = sumOfFactors(userInput);
    System.out.println("The sum of the factors of "+userInput+" is "+sum);
    
    perfectNumberCheck(userInput);
    
    perfectNumberBoolean = perfectNumberTest(userInput);
    
    System.out.println("These are the perfect numbers between 1 and 500: "); 
    for (int i=1; i<MAX; i++){
      perfectNumberBoolean = perfectNumberTest(i);// used to run i through the perfect number test
      if (perfectNumberBoolean==true){// if the return value is true that means i is a perfect number
        perfectNumbers[i] = i;
        System.out.print(i+", ");
      }
    }
    System.out.println();
  }
  
  public static void outputFactors (int ui){
    
    int[] factors = new int [ui]; // array used to store factors of userInput
  
    System.out.println("The factors for "+ui+" are: ");
    for(int i=1; i<ui; i++){// loop used to check for factors from 1 to userInput 
      if (ui%i == 0){
        factors[i] = i;
        System.out.print(factors[i]+", ");
      }
    }
    System.out.println();
  }
  public static int sumOfFactors (int ui){
    int sumOfFactors = 0;
    for(int i=1; i<ui; i++){// loop used to accumulate factors 
      if (ui%i == 0){
        sumOfFactors = sumOfFactors+i;
      }
    }
    return sumOfFactors;
  }
  public static void perfectNumberCheck (int ui){
    int sum = sumOfFactors(ui);// utilize the sumOfFactors method to find out if a number is a perfect number or not
    if (sum==ui){
      System.out.println(ui+" is a perfect number");
    }else{
      System.out.println(ui+" is not a perfect number");
    }
  }
  public static boolean perfectNumberTest (int ui){
    int sum = sumOfFactors(ui);// same method as above, but returns a boolean value
    boolean yn;
    if (sum==ui){
      yn = true;
    }else{
      yn = false;
    }
    return yn;
  }
}