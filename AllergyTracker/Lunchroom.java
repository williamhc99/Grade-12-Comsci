/*
 * Name: William Chen, Marcus Ng, Matthew Deng, Ethan Tam
 * Date: May 30th 2017
 * Program Name: User
 * Description: Lunchroom object
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;// scanner to get input

public class Lunchroom extends RoomSuperclass
{
  ArrayList <String> BannedFood = new ArrayList <String>();
  static Scanner myScanner = new Scanner(System.in);
  
  User student = new User("none");
  
  public void getBannedFood()
  {
    BannedFood.add(student.getAllergy());
  }
  
  public void setSchedule()
  {
    
  }
  
  public void getSchedule()
  {
    
  }
  
}