/* 
 * Name: William Chen
 * Date: February 27 2017
 * Mr. Anandarajan
 * ICS4U Period 5
 * Objectives: Complete Recursion Exercise
 * Two Problems that you can solve with recursion:
 * Sorting, quick sort uses recursion
 * Finding sum of numbers
 */
import java.util.Scanner;

class Recursion_Exercises{
  public static void main (String args[]){
    Scanner s = new Scanner(System.in);
    System.out.println("Enter a positive integer value: ");
    int ui = s.nextInt();
    int product = factorial(ui);
    System.out.println(product);
    
    System.out.println("Enter a number: "); 
    int m = s.nextInt();
    System.out.println("Enter a number: "); 
    int n = s.nextInt();
    
    System.out.println("The greatest common factor is: "+euclid(m,n));
    
    System.out.println("Enter the exponent base: ");
    int x = s.nextInt();
    System.out.println("Enter the power: ");
    int b = s.nextInt();
    
    
    System.out.println("The exponent is equal to: "+power(x,b));
  }
  public static int factorial (int num){
    if (num>1){
      return num*factorial(num-1);
    }
    return 1;
  }
  public static int euclid(int m, int n){
    int swap;
    if (m>n){
      return euclid(n, m-n);
    }else if (m<n){
      return euclid(n,m);
    }return m;
  }
  public static double power(int b, int x){
    double exponent = b;
    if ((x-1)>0){
      return exponent*power(b, x-1);
    }else if ((x-1)<0){
      return 1/exponent*(power(b, x+1));
    }else if (x==0){
      b=1;
    }
    return exponent;
  }
}
