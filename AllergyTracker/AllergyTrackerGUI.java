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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AllergyTrackerGUI extends JFrame implements ActionListener{
  static HashMap<Integer, Classroom> map = new HashMap<Integer, Classroom>();
  
  JPanel pan1;
  JPanel pan2;
  JPanel pan3;
  JPanel pan3_1;
  JPanel pan3_2;
  JPanel pan4;
  
  JButton view;
  JButton clear;
  JButton add;
  
  JTextField input;
  
  JLabel instructions;
  JLabel[] scheduleTemplate = new JLabel[6];
  JLabel[] schedule = new JLabel[6];
  JLabel allergy;
  
  static int roomnum;
  static int num;
  
  public AllergyTrackerGUI(){
    
    setTitle ("Classroom Allergy Tracker");
    setSize(1280, 720);
    
    pan1 = new JPanel();
    pan2 = new JPanel();
    pan3 = new JPanel();
    pan3_1 = new JPanel();
    pan3_2 = new JPanel();
    pan4 = new JPanel();
    
    view = new JButton("View");
    view.addActionListener(this);
    clear = new JButton("Clear");
    clear.addActionListener(this);
    add = new JButton("Add");
    add.addActionListener(this);
    
    input = new JTextField(10);
    
    instructions = new JLabel("Enter room number: ");
    
    allergy = new JLabel();
    
    GridLayout layout1 = new GridLayout(2, 2);
    GridLayout layout2 = new GridLayout(6,1);
    
    setLayout(layout1);
    pan3.setLayout(layout1);
    pan3_1.setLayout(layout2);
    pan3_2.setLayout(layout2);
    
    for (int i=0; i<scheduleTemplate.length; i++){
      scheduleTemplate[i] = new JLabel("Timeslot "+(i+1)+":");
      schedule[i] = new JLabel();
      pan3_1.add(scheduleTemplate[i]);
      pan3_2.add(schedule[i]);
    }
    
    pan1.add(instructions);
    pan1.add(input);
    pan1.add(view);
    pan1.add(clear);
    pan2.add(add);
    pan3.add(pan3_1);
    pan3.add(pan3_2);
    pan4.add(allergy);
    
    add(pan1);
    add(pan2);
    add(pan3);
    add(pan4);
    
    setVisible(true);
    
  }
  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();
    if (command.equals("Add")){
       
      String a = JOptionPane.showInputDialog(null, "Please enter the classroom number", "Classroom Number", JOptionPane.PLAIN_MESSAGE);
      roomnum = Integer.parseInt(a);
      map.put(roomnum, new Classroom(roomnum,new ArrayList<User>()));
       
      String b = JOptionPane.showInputDialog(null, "Please enter the number of students", "Number of students", JOptionPane.PLAIN_MESSAGE);
      num = Integer.parseInt(b);
       
      String tempName[] = new String[num];
      String tempAllergy[] = new String [num];
      
      for (int i=0; i<num; i++){
        String c = JOptionPane.showInputDialog(null, "Please enter the name of student "+(i+1), "Name of student", JOptionPane.PLAIN_MESSAGE);
        String d = JOptionPane.showInputDialog(null, "Please enter the allergy of student "+(i+1), "Allergy", JOptionPane.PLAIN_MESSAGE);
        User u = new User(c,d);
        map.get(roomnum).al.add(u);
      }
      
      String[] temp = new String[6];
      for (int i = 0; i < 6; i++) {
        String e = JOptionPane.showInputDialog(null, "Please enter the class subject for timeslot "+(i+1), "Name of class/club", JOptionPane.PLAIN_MESSAGE);
        temp[i] = e;
      }
      map.get(roomnum).inputSchedule(temp);
    }
    if (command.equals("View")){
      System.out.println(0);
      roomnum = Integer.parseInt(input.getText());
      String[] temp = map.get(roomnum).outputSchedule();
      for (int i=0; i<temp.length; i++){
        schedule[i].setText(temp[i]);
        pan3.add(schedule[i]);
      }
    }
        
  }
  
  public static void displayMenu() {
    System.out.println("Enter 1 to view/edit your class schedule");
    System.out.println("Enter 2 to view/enter allergies");
    System.out.println("Enter 3 to write things to file");
    System.out.println("Enter 4 to exit the program");
  }
  
  public static void main(String[] args_) throws Exception {
    AllergyTrackerGUI frame1= new AllergyTrackerGUI();
    int option = 0;
    while (option != 4) {
      Scanner sc = new Scanner(System.in);
      int menu;
      //int roomnum;
      
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
          for (int i = 0; i < map.get(roomnum).al.size(); i++) {
            System.out.println(map.get(roomnum).al.get(i).getName()+ ": "+ map.get(roomnum).al.get(i).getAllergy());
          }
        }
        
        if (menu == 2) {
          System.out.println("Please enter the classroom number");
          roomnum = sc.nextInt();
          if (!map.containsKey(roomnum)) {
            map.put(roomnum, new Classroom(roomnum,new ArrayList<User>()));
          }
          
          Classroom cr = map.get(roomnum);
          
          System.out.println("Please enter the number of users in this classroom");
          //int num = sc.nextInt();
          num = sc.nextInt();
          
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

