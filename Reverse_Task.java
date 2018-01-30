/* Name: William Chen
 * Date: February 7 2017
 * Mr. Anandarajan
 * ICS4U Period 5
 * Objectives: Reverse an user entered integer number wihtout using any java API methods
 */
import java.util.Scanner;

class Reverse_Task {
  public static void main (String args[]) {
    Scanner myScanner = new Scanner(System.in);
    
    System.out.println("Enter a number to be reversed:");
    int originalInt = myScanner.nextInt();//variable to store number that will be reversed

    int reverseInt = 0;//variable to store reversed number
   
    do{//loop to change number into reversed number
      reverseInt = (reverseInt*10)+(originalInt%10);
      originalInt = originalInt/10;
    }while(originalInt>0);
    System.out.println("Your number reversed is: "+reverseInt);//this statement outputs the reversed integer
  }
}
/* Code does not work if the input value ends with a 0 in the way that the zero will be omitted in the output
 */

    
  