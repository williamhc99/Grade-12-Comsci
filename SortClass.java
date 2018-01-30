/* 
 * Name: William Chen
 * Date: March 8 2017
 * Mr. Anandarajan
 * ICS4U Period 5
 * Objectives: Complete Level 1 Sorting Exercises
 */

import java.util.Scanner;
import java.io.*;
class SortClass{
  public static void main (String args[])throws Exception{
    Scanner s = new Scanner (System.in);
    File name = new java.io.File("Names.txt");
    File sorted = new java.io.File("Sorted.txt");
    PrintWriter output = new PrintWriter(name);
    PrintWriter o = new PrintWriter(sorted);
    final int MAX = 5;
    int [] phoneNum = new int[MAX];
    String [] names = new String[MAX];
    for (int i=0; i<MAX; i++){
      System.out.println("Enter the first name and last name: ");
      names[i] = s.nextLine();
      System.out.println("Enter the phone number: ");
      phoneNum[i] = s.nextInt();
      s.nextLine();
    }
    System.out.println("Names and phone numbers entered: ");
    for (int i=0; i<names.length; i++){
      System.out.println(names[i]+": "+phoneNum[i]);
      output.println(names[i]+": "+phoneNum[i]);
    }
    sort(names, phoneNum);
    System.out.println("Names sorted alphabetically: ");
    for (int i=0; i<names.length; i++){
      System.out.println(names[i]+": "+phoneNum[i]);
      o.println(names[i]+": "+phoneNum[i]);
    }
    output.close();
    o.close();
  }
  public static void sort (String[] list, int[] num){ 
    String hold;
    int j;
    for (int i=1; i<list.length; i++){
      hold = list[i];
      j = i;
      while (j>0&&list[j-1].compareToIgnoreCase(hold)>0){
        list[j] = list[j-1];
        num[j] = num[j-1];
        j--;
      }
      list[j] = hold;
      num[j] = num[i];
    }
  }
}