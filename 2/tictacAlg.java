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
  boolean XisGoing;   //  switching turns
  char board[][] = {{'A','A','A'}, {'A','A','A'}, {'A','A','A'}};  //  3x3 array to represent the board

  //  the board, note that the format that I will be addressing the board will
  //  be like a number pad so:
  //  7 8 9
  //  4 5 6
  //  1 2 3  will be the grid

  public void clicked1(){
    if ((board[0][0] == 'X') || (board[0][0] == 'O')){
      System.out.println("Already been filled.");
    }
    else{
      System.out.println("Filling..");
    }

  }  //  end of 1clicked

}  //  end of program
