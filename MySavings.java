import java.util.Scanner;
import java.util.ArrayList;

public class MySavings
{
  public static void main (String args[])
  {
    Scanner sc = new Scanner (System.in);
    
    PiggyBank savings = new PiggyBank();
    
    ArrayList <Coins> change = new ArrayList <Coins>();
    
    boolean full = false;
    int counter =0; 
    
    do
    {
      System.out.println("Enter 1 to add a coin, enter 2 to take away a coin, enter 3 to display balance.");
      
      int ui = sc.nextInt();
      
      
      //adding coins to the piggy bank
      if (ui==1)
      {
        System.out.println("Enter 1 to add a penny, enter 2 to add a nickel, enter 3 to add a dime, enter 4 to add a quarter.");
        ui = sc.nextInt();
        
        if(ui==1)
        {
          change.add(new Penny());
          savings.add((change.get(counter)).value());
        }
        else if (ui==2)
        {
          change.add(new Nickel());
          savings.add((change.get(counter)).value());
        }
        else if (ui==3)
        {
          change.add(new Dime());
          savings.add((change.get(counter)).value());
        }
        else if (ui==4)
        {
          change.add(new Quarter());
          savings.add((change.get(counter)).value());
        }
        counter++;
      }
      
      //removing coins from the piggy bank
      else if (ui==2)
      {
        System.out.println("Enter 1 to remove a penny, enter 2 to remove a nickel, enter 3 to remove a dime, enter 4 to remove a quarter.");
        ui = sc.nextInt();
        if(ui==1)
        {
          change.remove(new Penny());
          savings.subtract((new Penny()).value());
        }
        else if (ui==2)
        {
          change.remove(new Nickel());
          savings.subtract(new Nickel().value());
        }
        else if (ui==3)
        {
          change.remove(new Dime());
          savings.subtract(new Dime().value());
        }
        else if (ui==4)
        {
          change.remove(new Quarter());
          savings.subtract((new Quarter()).value());
        }
        counter--;
      }
      
      // displaying current account balance
      else if (ui==3)
      {
        savings.display();
      }
      
      // exiting program
      else if (ui==4)
      {
        full=true;
      }

    }while (full==false);
  }
}
