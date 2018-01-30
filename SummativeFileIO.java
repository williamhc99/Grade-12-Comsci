/* Name: Marcus Ng
 * Date: February 8th, 2017
 * Program Name: File Handling
*/

import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.*;

class SummativeFileIO
{
  public static void main(String args[]) throws Exception
  {
    Scanner myScanner= new Scanner(System.in);
    
    File unsort = new java.io.File ("UNSORT.DAT");
    Scanner input = new Scanner (unsort);
      
    ArrayList PeopleName = new ArrayList ();
    ArrayList PeopleNumber = new ArrayList ();
    
    while (input.hasNext())
    {
      PeopleName.add (input.next());
      PeopleNumber.add (input.next ());
    }
    
    for (int i = 0; i<PeopleName.size(); i++)
    {
      System.out.println (PeopleName.get (i));
      System.out.println (PeopleNumber.get (i));
    }
    
    SortNames (PeopleName, PeopleNumber);
  }
  
  public static void 
}