/* Name: Marcus Ng
 * Date: February 8th, 2017
 * Program Name: File Handling
*/

import java.io.PrintWriter;
import java.io.File;
import java.util.*;

class SortClass 
{
  public static void main(String args[]) throws Exception
  {
    Scanner myScanner= new Scanner(System.in);
    File names = new java.io.File ("Names.txt");
    PrintWriter output = new PrintWriter(names);
    int MAX = 5;
    
    String Names [] = new String [MAX];
    String Phone [] = new String [MAX];
    
    for (int i = 0; i<Names.length; i++)
    {
      System.out.println ("Enter the person's name");
      Names[i] = myScanner.nextLine ();
      output.println (Names[i]);
      
      System.out.println ("Enter the person's phone number");
      Phone[i] = myScanner.nextLine ();
      output.println (Phone[i]);
      
    }
    output.close ();
    
    for (int i = 0; i<Names.length; i++)
    {
      System.out.println (Names[i] + " - " + Phone[i]);
    }
    
    SortName (Names, Phone);
  }
  
  public static void SortName (String Names [], String Phone []) throws Exception
  {
    File SortNames = new java.io.File ("Sorted.txt");
    PrintWriter output = new PrintWriter(SortNames);
    
    String hold;
    String hold2;
    int j;
    
    for (int i =1; i<Names.length; i++)
    {
      hold = Names[i];
      hold2 = Phone[i];
      j=i;
      while (j>0 && Names[j-1].compareTo (hold)>0)
      {
        Names[j] = Names[j-1];
        j--;
      }
      Names[j] = hold;
      Phone[j] = hold2;
    }
    
    for (int i = 0; i<Names.length; i++)
    {
      output.println (Names[i]);
      output.println (Phone[i]);
    }
    
    output.close();
    

  }
    
    
    
   

}