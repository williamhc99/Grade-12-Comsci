import java.util.Scanner;
class noDuplicate{
  public static void main (String args[]){
    Scanner s = new Scanner (System.in);
    final int MAX = 5;
    int[] list = new int[MAX];
    boolean unique=false;
    System.out.println("Enter a number: ");
    list[0] = s.nextInt();
    for (int i=1; i<MAX;i++){
      System.out.println("Enter a number: ");
      int temp = s.nextInt();
      for (int j=0; j<i; j++){
        if (temp==list[j]){
          System.out.println("UI is not unique");
        }else{
          list[i]=temp;
          unique=true;
        }  
      }
      if (unique==true){
        i++;
      }
    }
    for (int i=0; i<MAX; i++){
      System.out.println(list[i]);
    }
  }
}
      