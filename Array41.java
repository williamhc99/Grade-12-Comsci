/* 
 * Name: William Chen
 * Date: March 27 2017
 * Mr. Anandarajan
 * ICS4U Period 5
 * Objectives: Complete Level 4 Array Exercises Part B
 */
 import java.util.Scanner;
 
 class Array41{
   static Scanner s = new Scanner(System.in);
   public static void main (String args[]) throws Exception {
     
     int row = 3;
     int column = 4;
     int [][] array = new int[row][column];
     fill(array);
     display(array);
     transpose(array);
     totalsum(array);

   }
   
   public static void fill (int [][] array){
     for (int r=0; r<array.length; r++){
       for (int c=0; c<array[r].length; c++){
         System.out.println("Enter data point "+r+", "+c);
         array[r][c] = s.nextInt();
       }
     }
   }
   
   public static void display (int[][] array){
     System.out.println("Array data point grid: ");
     for (int r=0; r<array.length; r++){
       for (int c=0; c<array[r].length; c++){
         System.out.print(array[r][c]+", ");
       }
       System.out.println();
     }
   }
   
   public static void transpose(int [][] array){
     System.out.println("Array data point grid transposed: ");
     for (int c=0; c<array[0].length; c++){
       
       for (int r=0; r<array.length; r++){
         System.out.print(array[r][c]+", ");
       }
       System.out.println();
     }
   }
   
   public static void totalsum (int[][] array){
     System.out.println("Array data point grid with sums: ");
     int rowSum=0;
     int colSum=0;
     
     for (int r=0; r<array.length; r++){
       rowSum = 0;
       
       for (int c=0; c<array[r].length; c++){
         System.out.print(array[r][c]+", ");
         rowSum+=array[r][c];
       }
       System.out.print(rowSum);
       System.out.println();
     }
     for (int c=0; c<array[0].length; c++){
       colSum =0;
       for (int r=0; r<array.length; r++){
         colSum+=array[r][c];
       }
       System.out.print(colSum+ ", ");
     }
   }
     
 }