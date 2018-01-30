import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * [GUIExample.java]
 * Author: Mrs. Andrighetti
 * Date: October 22, 2015
 * Description:  This class serves as a demonstration on how to create a simple
 *               GUI with a GridLayout and labels in each section of the layout.
 *               The labels will change colour when the buttons are clicked.
 */
public class GUIExample extends JFrame implements ActionListener {
  // class variables
  // buttons used to change the colour of the label text
  JButton redButton = new JButton("RED"); 
  JButton blueButton = new JButton("BLUE");
  
  // grid layout of the frame
  GridLayout layout1 = new GridLayout(3,2);//3 rows of 2 columns each
  
  // labels that will be added to the layout
  JLabel label1 = new JLabel("Label1");// JLabel [][]Grid = new JLabel [ROW][COL];
  JLabel label2 = new JLabel("Label2");
  JLabel label3 = new JLabel("Label3");
  JLabel label4 = new JLabel("Label4"); 
  
  /**
   * Class Contructor.  This constructor will add all the components to the 
   * frame.
   */
  public GUIExample() { 
    setTitle("GUIExample Frame");
    setSize(320, 240);
    
    // set layout for the whole canvas  
    setLayout(layout1);//3X2
    
    // add components
    add(label1);
    add(label2);
    add(label3);
    add(label4);

    redButton.addActionListener(this);
    add(redButton);
    blueButton.addActionListener(this);
    add(blueButton);
    
    setVisible(true);
  }
  
  /**
   * This method will perform the action retrieved from the event listener.
   * If the command is 'RED', then all labels will be set to red.
   * If the command is 'BLUE', then all labels will be set to blue.
   */
  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();
    if (command.equals("RED")) {
      label1.setForeground(Color.RED);//Note to set label colour - case sensitive
      label2.setForeground(Color.RED);
      label3.setForeground(Color.RED);
      label4.setForeground(Color.RED);      
    } else if (command.equals("BLUE")) {
      label1.setForeground(Color.BLUE);
      label2.setForeground(Color.BLUE);
      label3.setForeground(Color.BLUE);
      label4.setForeground(Color.BLUE); 
    }
  }
  
  /**
   * Main method.  Will create the frame.
   */
  public static void main(String[] args) {
    GUIExample frame1 = new GUIExample();
  }// end main
}// end class