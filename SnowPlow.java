import java.util.Scanner;
import java.util.Random;

class SnowPlow{
  
  static int row;// number of rows in 2d array
  static int col;// number of columns in 2d array
  static Scanner s = new Scanner (System.in);
  static Random rn = new Random();
  
  public static void main (String args[]){
    
    row = s.nextInt();
    col = s.nextInt();
    
    int [][] array = new int[row][col];//declare 2d array
    
    set(array);//setting 2 array randomly with 1s and 2s
    
    display(array);// display
    
    int first = find(array);//find and return horizontal index of first 1 aka start point, returns -1 if no 1 is found on first row
    
    if (first!=-1){//starts snowplow
      snowplow(0,first,array);
    } else {//output snowplow is not used
      System.out.println("Plow is not used");
    }
    
    System.out.println();
    
    display(array);
    
  }
  
  public static void set (int array[][]){
    for (int r = 0; r<array.length; r++){
      for (int c = 0; c<array[r].length; c++){
        array[r][c]=rn.nextInt(2)+1;
      }
    }
  }
  
  public static void display (int array[][]){
    for (int r = 0; r<array.length; r++){
      for (int c = 0; c<array[r].length; c++){
        System.out.print(array[r][c]+" ");
      }
      System.out.println();
    }
  }
  
  public static int find (int array[][]){
    for (int c = 0; c<array[0].length; c++){
      if (array[0][c]==1){// finding the first 1 and returning it
        return c;
      }
    }
    return -1;// if nothing was returned, method returns -1
  }
  
 /*
  * There are a total of 9 scenarios and 8 ways to check if snowplow goes on
  * 
  *  9 Scenarios:
  *     1 2 3 
  *     4 5 6 
  *     7 8 9
  * 
  * 1. r==0, c==0
  * 2. r==0, c!=0&&c!=col-1
  * 3. r==0, c==col-1
  * 4. r!=0&&r!=row-1, c==0
  * 5. r!=0&&r!=row-1, c!=0&&c!=col-1
  * 6. r!=0&&r!=row-1, c==col-1
  * 7. r==row-1, c==0
  * 8. r==row-1, c!=0&&c!=col-1
  * 9. r==row-1, c==col-1
  * 
  * 
  *  8 ways to check if snowplow goes on (letter I is current index)
  *     1 2 3 
  *     4 I 5
  *     6 7 8
  * 
  *
  */
  
  public static void snowplow (int r, int c, int array[][]){
    
    array[r][c] = 0;//sets array index passed into snowplow method as 0
    if (r==0){
      
      if (c==0){
        posFive(r, c, array);
        posEight(r, c, array);
        posSeven(r, c, array);
        
      }else if (c!=0&&c!=col-1){
        posFour(r, c, array);
        posSix(r, c, array);
        posFive(r, c, array);
        posEight(r, c, array);
        posSeven(r, c, array);
        
      }else if (c==col-1){
        posFour(r, c, array);
        posSix(r, c, array);
        posSeven(r, c, array);
      }   
      
    }else if (r!=0&&r!=row-1){
      if (c==0){
        posTwo(r, c, array);
        posThree(r, c, array);
        posFive(r, c, array);
        posEight(r, c, array);
        posSeven(r, c, array);  
      
      }else if (c!=0&&c!=col-1){
        posTwo(r, c, array);
        posThree(r, c, array);
        posFive(r, c, array);
        posEight(r, c, array);
        posSeven(r, c, array);
        posSix(r, c, array);
        posFour(r, c, array);
        posOne(r, c, array);
        
      }else if (c==col-1){
        posSeven(r, c, array);
        posSix(r, c, array);
        posFour(r, c, array);
        posOne(r, c, array);
        posTwo(r, c, array);
        
      }
   
    }else if (r==row-1){
      if (c==0){
        posTwo(r, c, array);
        posThree(r, c, array);
        posFive(r, c, array);
      
      }else if (c!=0&&c!=col-1){
        posFive(r, c, array);
        posThree(r, c, array);
        posTwo(r, c, array);
        posOne(r, c, array);
        posFour(r, c, array);
     
      }else if (c==col-1){
        posTwo(r, c, array);
        posOne(r, c, array);
        posFour(r, c, array);
        
      }
    }
  }
  public static void posOne (int r, int c, int[][] array){
    if (array[r-1][c-1]==1){
      snowplow(r-1,c-1,array);
    }
  }
  public static void posTwo (int r, int c, int[][] array){
    if (array[r-1][c]==1){
      snowplow(r-1,c,array);
    }
  }
  public static void posThree (int r, int c, int[][] array){
    if (array[r-1][c+1]==1){
      snowplow(r-1,c+1,array);
    }
  }
  public static void posFour (int r, int c, int[][] array){
    if (array[r][c-1]==1){
      snowplow(r, c-1,array);
    }
  }
  public static void posFive (int r, int c, int[][] array){
    if (array[r][c+1]==1){
      snowplow(r,c+1,array);
    }
  }
  public static void posSix (int r, int c, int[][] array){
    if (array[r+1][c-1]==1){
      snowplow(r+1,c-1, array);
    }
  }
  public static void posSeven (int r, int c, int[][] array){
    if (array[r+1][c]==1){
      snowplow(r+1,c,array);
    }
  }
  public static void posEight (int r, int c, int[][] array){
    if (array[r+1][c+1]==1){          
      snowplow(r+1,c+1,array);
    }
  }

  

}

  


        