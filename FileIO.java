/* 
 * Name: William Chen
 * Date: March 20 2017
 * Mr. Anandarajan
 * ICS4U Period 5
 * Objectives: Complete Additional Exercises #1
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
class FileIO{
   static Scanner s = new Scanner(System.in);
   public static void main (String args[])throws Exception{
     Scanner s = new Scanner(System.in);
     File unsort = new java.io.File ("Unsort.DAT");
     Scanner input = new Scanner (unsort);
     ArrayList name = new ArrayList ();
     ArrayList number = new ArrayList ();
     
     while (input.hasNext()){
      name.add (input.nextLine());
      number.add (input.nextLine());
     }
     
     for (int i = 0; i<name.size(); i++){
       System.out.println (name.get (i));
       System.out.println (number.get (i));
     }
     
     System.out.println("Press enter to sort.");
     s.nextLine();
     sort(name, number);
     Display(name, number);
     
     File sorted = new java.io.File("Sorted.txt");
     PrintWriter o = new PrintWriter(sorted);
     
     for (int i = 0; i<name.size(); i++){
       o.println (name.get(i));
       o.println (number.get (i));
     }
     o.close();
   }
   public static void sort (ArrayList <String> list, ArrayList <String> num){ 
     String hold;
     Integer j;
     for (int i=1; i<list.size(); i++){
       hold = list.get(i);
       j = i;
       while (j>0&&list.get(j-1).compareToIgnoreCase(hold)>0){
         list.set(j, list.get(j-1));
         num.set(j, num.get(j-1));
         j--;
       }
       list.set(j, hold);
       num.set(j, num.get(i));
     }
   }
   
   public static void Display (ArrayList list, ArrayList num){// use for loop to show all values in array
     System.out.println("Sorted Alphabetically by Last Name:");
     for (int i=0; i<list.size(); i++){
       System.out.println(list.get(i));
       System.out.println(num.get(i));
     }
   }
}