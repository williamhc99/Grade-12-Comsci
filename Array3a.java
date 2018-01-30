/* 
 * Name: William Chen
 * Date: February 8 2017
 * Mr. Anandarajan
 * ICS4U Period 5
 * Objectives: Complete Level 3 Array Exercises
 */

import java.util.Scanner;
import java.util.Random;

class Array3a{
  static Scanner myScanner = new Scanner (System.in);
  static Random rn = new Random ();
  public static void main (String args[]){
    int placeholder=0;
    NoDuplicates(placeholder);
    RandomNoDuplicates(placeholder);
    RandomOrder(placeholder);
    ThreeRandomOrder(placeholder);
  }
  public static void NoDuplicates (int counter){
    final int MAX = 7;
    int[] list = new int[MAX];
    int[] occurrence = new int [5];
    while(counter<7){  
      System.out.println("Enter number: ");
      list[counter] = myScanner.nextInt();
      if(occurrence[list[counter]]==1){
        System.out.println("This number has been entered already.");
      }else{
        occurrence[list[counter]]++;
        counter++;
      }
    }
    for (int i=0; i<MAX; i++){
      System.out.println(list[i]);
    }
  }
  public static void RandomNoDuplicates (int counter){
    final int MAX = 10;
    int[] randomList = new int[MAX];
    int[] occurrence = new int[100];
    while (counter<10){
      randomList[counter]=rn.nextInt(100);
      if(occurrence[randomList[counter]]==0){
        occurrence[randomList[counter]]++;
        counter++;
      }
    }
    for (int k=0; k<MAX; k++){
      System.out.println(randomList[k]);
    }
  }
  public static void RandomOrder (int counter){
    final int MAX = 5;
    int[] randomList= new int[MAX];
    int[] occurrence = new int [MAX];
    String[] swimmerNames = new String[MAX];
    for (int i=0; i<MAX; i++){
      swimmerNames[i] = "Swimmer "+(i+1);
    }
    while (counter<5){
      randomList[counter]=rn.nextInt(5);
      if(occurrence[randomList[counter]]==0){
        occurrence[randomList[counter]]++;
        counter++;
      }
    }
    for (int i=0; i<MAX; i++){
      System.out.println(swimmerNames[randomList[i]]);
    }
  }
  public static void ThreeRandomOrder (int counter){
    final int MAX = 5;
    int[] randomList= new int[MAX];
    int[] occurrence = new int [MAX];
    int[] first = new int [MAX];
    int[] last = new int [MAX];
    boolean unique;
    String[] swimmerNames = new String[MAX];
    for (int a=0; a<3; a++){
      System.out.println("Order "+(a+1));
      
      for (int i=0; i<MAX; i++){
        swimmerNames[i] = "Swimmer "+(i+1);
      }
      do {
        arrayFill(occurrence, 0);
        arrayFill(randomList, 0);
        counter=0;
        while (counter<5){
          randomList[counter]=rn.nextInt(5);
          if(occurrence[randomList[counter]]==0){
            occurrence[randomList[counter]]++;
            counter++;
          }
        }
        if ((first[randomList[0]]==0)&&(last[randomList[4]]==0)){
          first[randomList[0]]++;
          last[randomList[4]]++;
          unique = true;
        }else{
          unique = false;
        }
      }while (unique==false);
      for (int i=0; i<MAX; i++){
        System.out.println(swimmerNames[randomList[i]]);
      }
    }
  }
  public static void arrayFill (int[] list, int num){
    for (int i=0; i<list.length; i++){
      list[i]=num;
    }
  }
}