import javax.swing.*;//Import the 3 libraries
import java.awt.*;
import java.awt.event.*;

public class Tic_Tac_Toe extends JFrame implements ActionListener   //Class definition
{ 
  
  //Global variables
  
  // SET UP GUI ELEMENTS
  JPanel buttonpanel = new JPanel();
  
//Declaring a single button
  JButton addButton = new JButton("How to play");//One step process
  
  //Declare an array of buttons  or labels
  
  final int ROW = 3;
  final int COL = 3;
  
  
  JButton Buttons[][]= new JButton[ROW][COL];// //Declare 2D array of buttons
  
  //Declare 2D array of labels
  
  JLabel [][]TwoDLabels = new JLabel [ROW][COL];//Just declared 
  
  //Declare 2D array of numbers - grid
  int AIGrid[][]= new int [ROW][COL];
  
   String UserGrid[][]= new String [ROW][COL];
  
  JButton searchButton = new JButton("Open a previously saved file");   
  JButton deleteButton = new JButton("Store current game to a file"); 
  JButton quitButton = new JButton("Quit"); 
  
  JPanel Intropanel = new JPanel();
  JPanel ArrayButtonPanel = new JPanel ();
  
  JPanel infopanel = new JPanel();
  JLabel namelabel = new JLabel("Name:",JLabel.RIGHT);
  JTextField namefield = new JTextField(20);
  JLabel numberlabel = new JLabel("Student Number:",JLabel.RIGHT);
  JTextField numberfield = new JTextField(20);
  
  JPanel statuspanel = new JPanel();
  JLabel welcomelabel = new JLabel("Welcome to .... Tic_Tac_Toe Game - Please enter your selection",JLabel.CENTER);
  JLabel statuslabel = new JLabel("Waiting for selection..",JLabel.CENTER);
  
  
  //In the constructor method I am  initializing values
  public Tic_Tac_Toe()   //COnstructor method - same name as the Class name
  { 
    
    //Button construction and setting
    
   
    
    String snumber;
    int button_value;
    //This section is to name each of the 2D array of buttons
    for (int row=0; row<ROW; row++)
    {
      for (int col=0; col<COL; col++)
      {
        button_value = row*3+(col+1);//get each buttons value in int form
        snumber = Integer.toString(button_value);//Type casting an integer value to string
        Buttons[row][col] =new JButton(snumber);//Text that appears on the array of buttons is set here
        //TwoDLabels[row][col]= new JLabel(snumber);//TExt that appears on the array of labels is set here
        //
      }
    }
    
    //TEMP
    
    //TEMP
    
    //label1.setForeground(Color.RED);
    
    setTitle("2D Array for Tic_Tac_Toe");
    setSize(800, 600);
    
    FlowLayout layout1 = new FlowLayout();  
    GridLayout layout2 = new GridLayout(4,1);
    
    
    GridLayout Array_Button_Layout = new GridLayout(ROW, COL);//important
    
    setLayout(layout2);//Setting the layout of the whole frame
    
    buttonpanel.setLayout(layout1);
    
    
    addButton.addActionListener(this);//Addind of the listener to the buttons
    searchButton.addActionListener(this);
    deleteButton.addActionListener(this);
    quitButton.addActionListener(this);
    
    Intropanel.setLayout(layout1);
    
    Intropanel.add(welcomelabel);
    
    buttonpanel.setLayout(layout1);
    //Add the buttons to a panel
    buttonpanel.add(addButton);//adding buttons to a panel
    buttonpanel.add(searchButton);
    buttonpanel.add(deleteButton);
    buttonpanel.add(quitButton);
    
    
    
    ArrayButtonPanel.setLayout(Array_Button_Layout);
    
    //Add array of buttons - array of buttons
    
    
    
    for (int row=0; row<ROW; row++)
    {
      for (int col=0; col<COL; col++) {
        Buttons[row][col].addActionListener(this);//Adding the action listener - now this button has a name and action listener
        ArrayButtonPanel. add(Buttons[row][col]) ;
       // Panel1. add(Label[row][col]);
      }
    }
    
      //Filling 2D array with some numbers
    
    
    
    for (int row=0; row<ROW; row++)
    {
      for (int col=0; col<COL; col++) {
        AIGrid[row][col]= 0 ;
        
      }
    }
    
      AIGrid[1][2]= 5 ;
      
      
      
       UserGrid[0][0]="c";
       UserGrid[0][1]="c";
       
      // if ( UserGrid[UR][UC]="c" && 
    statuspanel.add(statuslabel);
    //Add panel
    
    add(Intropanel);
    
   
    add(ArrayButtonPanel);
    
    add(buttonpanel);
    
    add(statuspanel);
    
     
    // pan2 = new drawingPanel2();
    
    // add(pan2);
    
    
    setVisible(true); 
  }
  //Interaction section
  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();//gets the name of the button
    
    for (int row=0; row<ROW; row++)
    {
      for (int col=0; col<COL; col++){
        if(Buttons[row][col]==event.getSource()){
          
          //
          System.out.println("Row "+(row+1)+ "and Column "+(col+1)+" th button was pressed");
          //Buttons[row][col]=new JButton("clicked");
        }
      }
    }
    
    
    if (command.equals("How to play")) {
      System.out.println("How to play button was pressed");
      
      
    } else if (command.equals("Quit")) {
      System.out.println("quit button pressed");
      dispose();
    }
    
    
  }
  
  public static void main(String[] args) {
    new Tic_Tac_Toe();
  }
  
}
