//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  14 September 2017
//Last edited:  21 September 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     #2
//Due date:

//Purpose of this program:
//This program will simulate a tic tac toe game and use radio buttons to
//determine the first player's selection.
//Graphics will be used to draw and simulate the playing field.

//File name:  tictacAlg.java
//Purpose of this specific source file:
//  Hold the boolean values of the program and win conditions.

//Tier 3

import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;

class Graphicpanelclass extends JPanel{
  //  declarations of variables
  boolean gameStarted;
  boolean XisGoing = true;   //  switching turns
  char board[][] = {{'A','A','A'}, {'A','A','A'}, {'A','A','A'}};  //  3x3 array to represent the board

  //  the board, note that the format that I will be addressing the board will
  //  be like a number pad so:
  //  7 8 9
  //  4 5 6
  //  1 2 3  will be the grid

  public void switchPlayer(){
    XisGoing = !XisGoing;
  }

  public void clicked1(){
    if ((board[0][0] == 'X') || (board[0][0] == 'O')){
      System.out.println("Already been filled.");
    }
    else{
      if (XisGoing == true){
        board[0][0] = 'X';
      }
      else board[0][0] = 'O';
    }
  }  //  end of 1clicked

  public void clicked2(){
    if ((board[1][0] == 'X') || (board[1][0] == 'O')){
      System.out.println("Already been filled.");
    }
    else{
      if (XisGoing == true){
        board[1][0] = 'X';
      }
      else board[1][0] = 'O';
    }
  }  //  end of 2clicked




  protected void paintComponent(Graphics g){
    System.out.println("I have been called.");
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    Graphics2D g3 = (Graphics2D)g;



    //  playing field
    g2.setColor(Color.BLACK);
    g2.setStroke(new BasicStroke(4f));

    g2.drawLine(200,0,200,600);
    g2.drawLine(400,0,400,600);
    g2.drawLine(0,200,600,200);
    g2.drawLine(0,400,600,400);

    //  drawing X's
    g3.setStroke(new BasicStroke(8f));
    g3.setColor(Color.RED);

    if (board[0][0] == 'X'){
      g3.drawLine(10,410,190,590);
      g3.drawLine(10,590,190,410);
    }

    if (board[1][0] == 'X'){
      g3.drawLine(210,410,390,590);
      g3.drawLine(210,590,390,410);
    }






  }  //  end of paint component

}  //  end of program
