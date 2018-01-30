import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.awt.event.*;
public class Maze extends JFrame implements ActionListener {
  
  JPanel panel1;
  JPanel panel2;
  JPanel panel3;
  JButton[][] button;
  JButton click;
  JLabel nopath;
  
  
  public static char[][] maze;
  public static int row;
  public static int col;
  public static int sX;
  public static int sY;
  public static int endX;
  public static int endY;
  public static boolean flag = false;
  public static boolean noPath = false;
  public static Scanner sc = new Scanner(System.in);
  
  public static char border = 'B';
  public static char open = 'O';
  public static char start = 'S';
  public static char exit = 'X';
  
  public Maze(){
    
    panel1 = new JPanel();
    panel2 = new JPanel();
    panel3 = new JPanel();
    
    GridLayout layout = new GridLayout(row,col);
    FlowLayout layout2 = new FlowLayout();
    
    button = new JButton[row][col];
    
    click = new JButton("Findpath");
    
    nopath = new JLabel("",JLabel.CENTER);
    
    setLayout(new GridLayout(3,1));
    setSize(640,480);
    
    panel1.setLayout(layout);
    panel2.setLayout(new GridLayout(2,2));
    panel3.setLayout(layout);
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        button[i][j] = new JButton(maze[i][j]+"");
        panel1.add(button[i][j]);
      }
    }
    click.addActionListener(this);
    panel2.add(click);
    panel2.add(nopath);
    
    add(panel1);
    add(panel2);
    add(panel3);
    setTitle("MouseMaze");
    
    setVisible(true);
    
  }
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    if(command.equals("Findpath")){
      findPath(sX,sY);
      if(maze[endX][endY]=='+'){
        panel3.setLayout(new GridLayout(row,col));
        for(int i=0;i<row;i++){
          for(int j=0;j<col;j++){
            button[i][j].setText(maze[i][j]+"");;
            panel3.add(button[i][j]);
          }
        }
      }else{
        nopath.setText("No Path");
      }
    }
  }
  public static void main(String[] args) throws Exception{
    System.out.println("Please choose the option: 1 for input from file, 2 for manual input");
    int opt = sc.nextInt();
    if(opt==1){
      inputFile();
    }else{
      inputConsole();
      initMaze();
    }
    if(maze[endX][endY]=='+'){
      System.out.println("path");
    }else{
      System.out.println("no path");
    }
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        System.out.print(maze[i][j]+" ");
      }
      System.out.println("");
    }
     Maze mm = new Maze();
  }
  public static void inputConsole(){
    System.out.println("Please enter the number of rows");
    row = sc.nextInt();
    System.out.println("Please enter the number of columns");
    col = sc.nextInt();
    maze = new char[row][col];
  }
  
  public static void inputFile() throws Exception{
    System.out.println("Please enter the name of the file");
    String fileName = sc.next();
    File f = new java.io.File(fileName);
    Scanner sFile = new Scanner(f);
    row = Integer.parseInt(sFile.nextLine());
    col = Integer.parseInt(sFile.nextLine());
    maze = new char[row][col];
    border = sFile.nextLine().charAt(0);
    open = sFile.nextLine().charAt(0);
    start = sFile.nextLine().charAt(0);
    exit = sFile.nextLine().charAt(0);
    for(int i=0;i<row;i++){
      String temp = sFile.nextLine();
      for(int j=0;j<col;j++){
        maze[i][j] = temp.charAt(j);
        if(maze[i][j]==start){
          sX = i;
          sY = j;
        }else if(maze[i][j]==exit){
          endX = i;
          endY = j;
        }
        
      }
    }
  }
  
  public static void initMaze(){
    //randomize inside of the maze
    for(int i=1;i<row-1;i++){
      for(int j=1;j<col-1;j++){
        int num = (int)(Math.random()*2);
        if(num==0){
          maze[i][j] = open;
        }else{
          maze[i][j] = border;
        }
      }
    }
    //set top and bottom to border
    for(int i=0;i<col;i++){
      maze[0][i] = border;
      maze[row-1][i] = border;
    }
    //set left and right to border
    for(int i=1;i<row-1;i++){
      maze[i][0] = border;
      maze[i][col-1] = border;
    }
    
    int x = (int)(Math.random()*(col-2))+1;
    int y = (int)(Math.random()*(row-2))+1;
    maze[x][y] = start;
    sX = x;
    sY = y;
    
    int temp = (int)(Math.random()*4);
    x = (int)(Math.random()*(row-2))+1;
    y = (int)(Math.random()*(col-2))+1;
    endX = x;
    endY = y;
    
    if(temp==0){
      maze[0][y] = exit;
    }else if(temp==1){
      maze[row-1][y] = exit;
    }else if(temp==2){
      maze[x][0] = exit;
    }else{
      maze[x][col-1] = exit;
    }
    
    
  }
  
  public static void findPath(int r,int c){
    boolean[][] visited = new boolean[row][col];
    if(maze[r][c]==exit) {
      maze[r][c] = '+';
      return;
    }
    if(!visited[r][c]){
      visited[r][c] = true;
      if(maze[r][c]==open || maze[r][c] == start){
        maze[r][c] = '+';
        if(r>0) findPath(r-1,c);
        if(r<row-1) findPath(r+1,c);
        if(c>0) findPath(r,c-1);
        if(c<col-1) findPath(r,c+1);
      }
    }
  }
}
