public class PiggyBank
{
  int savings =0;
  
  public void add(int amount)
  {
    savings+=amount;
  }
  
  public void subtract(int amount)
  {
    savings-=amount;
  }
  
  public void display()
  {
    System.out.println("The current amount of money in the piggy bank is: "+savings);
  }
}