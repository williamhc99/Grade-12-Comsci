/*
 * Name: William Chen, Marcus Ng, Matthew Deng, Ethan Tam
 * Date: May 30th 2017
 * Program Name: AllergyTracker
 * Description: Classroom allergy tracker
 */

import java.awt.*;
import java.io.*;
import java.util.*;// scanner to get input
import java.io.PrintWriter;

public class AllergyTracker {
  static HashMap<Integer, Classroom> map = new HashMap<Integer, Classroom>();
  
  public static void displayMenu() {
    System.out.println("Enter 1 to view/edit your class schedule");
    System.out.println("Enter 2 to view/enter allergies");
    System.out.println("Enter 3 to write things to file");
    System.out.println("Enter 4 to exit the program");
  }
  
  public static void main(String[] args_) throws Exception {
    int option = 0;
    while (option != 4) {
      Scanner sc = new Scanner(System.in);
      int menu;
      int roomnum;
      
      displayMenu();
      
      option = sc.nextInt();
      
      if (option == 1) {
        System.out.println("Enter 1 to view the schedule");
        System.out.println("Enter 2 to edit the schedule");
        menu = sc.nextInt();
        
        if (menu == 1) {
          System.out.println("Enter the room number");
          roomnum = sc.nextInt();
          if (map.containsKey(roomnum)) {
            System.out.println(map.get(roomnum).outputSchedule());
          } else {
            System.out.println("Classroom does not exist");
          }
        }
        
        if (menu == 2) {
          System.out.println("Please enter the classroom number");
          roomnum = sc.nextInt();
          sc.nextLine();
          
          String[] temp = new String[6];
          for (int i = 0; i < 6; i++) {
            System.out.println("Please enter class subject for timeslot "+ (i + 1));
            temp[i] = sc.nextLine();
          }
          if (!map.containsKey(roomnum)) {
            map.put(roomnum, new Classroom(roomnum,new ArrayList<User>()));
          }
          map.get(roomnum).inputSchedule(temp);
        }
      }
      
      if (option == 2) {
        
        System.out.println("Enter 1 to view all allergys");
        System.out.println("Enter 2 to add allergies to a class");
        menu = sc.nextInt();
        
        if (menu == 1) {
          System.out.println("Please enter the classroom number");
          roomnum = sc.nextInt();
          if (map.containsKey(roomnum)) {
            for (int i = 0; i < map.get(roomnum).al.size(); i++) {//////////////////////////////////////////////////////////////////
              System.out.println(map.get(roomnum).al.get(i).getName()+ ": "+ map.get(roomnum).al.get(i).getAllergy());
            }
          }else{
            System.out.println("Classroom does not exist");
          }
          
          if (menu == 2) {
            System.out.println("Please enter the classroom number");
            roomnum = sc.nextInt();
            if (!map.containsKey(roomnum)) {
              map.put(roomnum, new Classroom(roomnum,new ArrayList<User>()));
            }
            
            Classroom cr = map.get(roomnum);
            
            System.out
              .println("Please enter the number of users in this classroom");
            int num = sc.nextInt();
            
            sc.nextLine();
            
            for (int i = 0; i < num; i++) {
              
              System.out.println("Please enter the name of the user");
              String temp = sc.nextLine();
              
              System.out.println("Enter the allergy for this user");
              String allergy = sc.nextLine();
              
              User u = new User(allergy, temp);
              cr.al.add(u);
            }
            
          }
        }
      }
      
      if (option == 3) {
        System.out.println("Enter the room number");
        Integer roomnumb = sc.nextInt();
        writeToFile(roomnumb);
      }
      
    }
  }
  
  public static void writeToFile(Integer roomnumb) throws Exception { //Write to file method
    
    //Initializing Files
    File Allergy = new java.io.File("Class " + roomnumb+".txt");
    PrintWriter output = new PrintWriter(Allergy);
    
    //Output things into the file
    output.println(roomnumb);
    output.println("Schedule:");
    
    String temp[] = map.get(roomnumb).outputSchedule(); //Store the schedule into the temp array
    for (int i = 0; i < 6; i++) {
      output.println("Period: " + (i+1) + " " + temp[i]); //Add the schedule into the array
    }
    
    output.println ("Banned Foods:" );
    
    for (int i = 0; i<map.get(roomnumb).al.size(); i++){
      output.println (map.get(roomnumb).al.get(i).getName()+ ": "+ map.get(roomnumb).al.get(i).getAllergy()); //gets the stored name of the student and their allergy
    }
    
    //Close the file
    output.close();
    
  }
}
