import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test extends JFrame
{
  JPanel pan1 = new JPanel();
  
  public Test()
  {
    setTitle ("Classroom Allergy Tracker");
    setSize(1280, 720);
    
    GridLayout layout1 = new GridLayout();
    pan1.setLayout (new GridLayout(2, 2));
    
    setLayout(layout1);
    
    String n = JOptionPane.showInputDialog(null, "Please enter the classroom number", "Classroom Number", JOptionPane.PLAIN_MESSAGE);
    String i = JOptionPane.showInputDialog(null, "Please enter the number of students", "Number of students", JOptionPane.PLAIN_MESSAGE);
    String j = JOptionPane.showInputDialog(null, "Please enter the student's name", "Name of student", JOptionPane.PLAIN_MESSAGE);
    String k = JOptionPane.showInputDialog(null, "Please enter the student's Allergy", "Allergy", JOptionPane.PLAIN_MESSAGE);
    
    JButton button1 = new JButton(n);
    JButton button2 = new JButton(i);
    JLabel label1 = new JLabel("                         " + j);
    JLabel label2 = new JLabel("                         " + k);
    
    button1.setFont(new Font("Calibri", Font.PLAIN, 40));
    button2.setFont(new Font("Courier New", Font.PLAIN, 40));
    label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
    label2.setFont(new Font("Buxton Sketch", Font.PLAIN, 40));
       
    button1.setVerticalAlignment(SwingConstants.TOP);
    button2.setVerticalAlignment(SwingConstants.TOP);

    pan1.add(button1);
    pan1.add(button2);
    pan1.add(label1);
    pan1.add(label2);
    
    if (n == null)
    {
      System.exit(0);
    }
    
    add(pan1);
    setVisible(true);
  }
  
  public static void main(String args[])
  {
    Test frame1 = new Test();
  }
  
}