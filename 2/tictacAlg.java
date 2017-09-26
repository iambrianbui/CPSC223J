//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  14 September 2017
//Last edited:  25 September 2017
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
  boolean canPlay = false;
  int turnCount = 0;
  boolean XisGoing = true;   //  switching turns
  char board[][] = {{'A','A','A'}, {'A','A','A'}, {'A','A','A'}};  //  3x3 array to represent the board

  //  the board, note that the format that I will be addressing the board will
  //  be like a number pad so:
  //  7 8 9
  //  4 5 6
  //  1 2 3  will be the grid


//  switch the current player
  public void switchPlayer(){
    XisGoing = !XisGoing;
    //  System.out.println("Player switched!");
  }

//  have X go first
  public void Xfirst(){
    if(turnCount==0)
    XisGoing = true;
    canPlay = true;
  }

//  have O go first
  public void Ofirst(){
    if(turnCount==0)
    XisGoing = false;
    canPlay = true;
  }

//  clear the board for a new game!
  public void newGame(){
    for (int i=0; i<3; i++){
      for (int j=0; j<3; j++){
        board[i][j] = 'A';
      }
    }
    canPlay = false;
    turnCount=0;
  }

//  clicked functions
  public void clicked1(){
    if(canPlay==true){
    if ((board[0][0] == 'X') || (board[0][0] == 'O')){
      System.out.println("Already been filled.");
    }
    else{
      if (XisGoing == true){
        board[0][0] = 'X';
      }
      else board[0][0] = 'O';
      switchPlayer();
    }
  }
  else
      System.out.println("Game has not started yet.");


  }  //  end of 1clicked

  public void clicked2(){
        if(canPlay==true){
    if ((board[1][0] == 'X') || (board[1][0] == 'O')){
      System.out.println("Already been filled.");
    }
    else{
      if (XisGoing == true){
        board[1][0] = 'X';
      }
      else board[1][0] = 'O';
      switchPlayer();
    }
  }
  else
      System.out.println("Game has not started yet.");

  }  //  end of 2clicked

  public void clicked3(){
        if(canPlay==true){
    if ((board[2][0] == 'X') || (board[2][0] == 'O')){
      System.out.println("Already been filled.");
    }
    else{
      if (XisGoing == true){
        board[2][0] = 'X';
      }
      else board[2][0] = 'O';
      switchPlayer();
    }
  }
  else
      System.out.println("Game has not started yet.");

  }  //  end of 3clicked

  public void clicked4(){
        if(canPlay==true){
    if ((board[0][1] == 'X') || (board[0][1] == 'O')){
      System.out.println("Already been filled.");
    }
    else{
      if (XisGoing == true){
        board[0][1] = 'X';
      }
      else board[0][1] = 'O';
      switchPlayer();
    }
  }
  else
      System.out.println("Game has not started yet.");

  }  //  end of 4clicked

  public void clicked5(){
        if(canPlay==true){
    if ((board[1][1] == 'X') || (board[1][1] == 'O')){
      System.out.println("Already been filled.");
    }
    else{
      if (XisGoing == true){
        board[1][1] = 'X';
      }
      else board[1][1] = 'O';
      switchPlayer();
    }
  }
  else
      System.out.println("Game has not started yet.");

  }  //  end of 5clicked

  public void clicked6(){
        if(canPlay==true){
    if ((board[2][1] == 'X') || (board[2][1] == 'O')){
      System.out.println("Already been filled.");
    }
    else{
      if (XisGoing == true){
        board[2][1] = 'X';
      }
      else board[2][1] = 'O';
      switchPlayer();
    }
  }
  else
      System.out.println("Game has not started yet.");

  }  //  end of 6clicked

  public void clicked7(){
        if(canPlay==true){
    if ((board[0][2] == 'X') || (board[0][2] == 'O')){
      System.out.println("Already been filled.");
    }
    else{
      if (XisGoing == true){
        board[0][2] = 'X';
      }
      else board[0][2] = 'O';
      switchPlayer();
    }
  }
  else
      System.out.println("Game has not started yet.");

  }  //  end of 7clicked

  public void clicked8(){
        if(canPlay==true){
    if ((board[1][2] == 'X') || (board[1][2] == 'O')){
      System.out.println("Already been filled.");
    }
    else{
      if (XisGoing == true){
        board[1][2] = 'X';
      }
      else board[1][2] = 'O';
      switchPlayer();
    }
  }
  else
      System.out.println("Game has not started yet.");

  }  //  end of 8clicked

  public void clicked9(){
        if(canPlay==true){
    if ((board[2][2] == 'X') || (board[2][2] == 'O')){
      System.out.println("Already been filled.");
    }
    else{
      if (XisGoing == true){
        board[2][2] = 'X';
      }
      else board[2][2] = 'O';
      switchPlayer();
    }
  }
  else
      System.out.println("Game has not started yet.");

  }  //  end of 9clicked
//  end of clicked functions

//  check
  public void gameStatus(){
    if(turnCount<10){
      turnCount++;
    }

    //  rows 1,2,3
    //  row 1
    if ((board[0][0]==board[1][0])&&(board[0][0])==board[2][0]){
      if (board[0][0]=='X'){
        System.out.println("X wins!");
        canPlay=false;
    }  //  x
    else if (board[0][0]=='O'){
      System.out.println("O wins!");
      canPlay=false;
    }  // o
    }

    //  row 2
    else if ((board[0][1]==board[1][1])&&(board[0][1])==board[2][1]){
      if (board[0][1]=='X'){
        System.out.println("X wins!");
        canPlay=false;
    }  //  x
    else if (board[0][1]=='O'){
      System.out.println("O wins!");
      canPlay=false;
    }  //  o
    }

    //  row 3
    else if ((board[0][2]==board[1][2])&&(board[0][2])==board[2][2]){
      if (board[0][2]=='X'){
        System.out.println("X wins!");
        canPlay=false;
    }  //  x
    else if (board[0][2]=='O'){
      System.out.println("O wins!");
      canPlay=false;
    }  //  o
    }

    //  columns 1,2,3
    //  column 1
    else if ((board[0][0]==board[0][1])&&(board[0][0])==board[0][2]){
      if (board[0][0]=='X'){
        System.out.println("X wins!");
        canPlay=false;
    }  //  x
    else if (board[0][0]=='O'){
      System.out.println("O wins!");
      canPlay=false;
    }  // o
    }

    //  column 2
    else if ((board[1][0]==board[1][1])&&(board[1][0])==board[1][2]){
      if (board[1][0]=='X'){
        System.out.println("X wins!");
        canPlay=false;
    }  //  x
    else if (board[1][0]=='O'){
      System.out.println("O wins!");
      canPlay=false;
    }  // o
    }

    //  column 3
    else if ((board[2][0]==board[2][1])&&(board[2][0])==board[2][2]){
      if (board[2][0]=='X'){
        System.out.println("X wins!");
        canPlay=false;
    }  //  x
    else if (board[2][0]=='O'){
      System.out.println("O wins!");
      canPlay=false;
    }  // o
    }

    // diagonals
    else if ((board[0][0]==board[1][1])&&(board[0][0])==board[2][2]){
      if (board[0][0]=='X'){
        System.out.println("X wins!");
        canPlay=false;
    }  //  x
    else if (board[0][0]=='O'){
      System.out.println("O wins!");
      canPlay=false;
    }  // o
    }

    else if ((board[0][2]==board[1][1])&&(board[0][2])==board[2][0]){
      if (board[0][2]=='X'){
        System.out.println("X wins!");
        canPlay=false;
    }  //  x
    else if (board[0][2]=='O'){
      System.out.println("O wins!");
      canPlay=false;
    }  // o
    }
    else if (turnCount>=9){
      System.out.println("It's a tie!");
      canPlay=false;
    }

  }





  protected void paintComponent(Graphics g){
    //  System.out.println("I have been called.");
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

    //  bottom row
    if (board[0][0] == 'X'){
      g3.drawLine(10,410,190,590);
      g3.drawLine(10,590,190,410);
    }
    if (board[1][0] == 'X'){
      g3.drawLine(210,410,390,590);
      g3.drawLine(210,590,390,410);
    }
    if (board[2][0] == 'X'){
      g3.drawLine(410,410,590,590);
      g3.drawLine(410,590,590,410);
    }

    //  middle row
    if (board[0][1] == 'X'){
      g3.drawLine(10,210,190,390);
      g3.drawLine(10,390,190,210);
    }
    if (board[1][1] == 'X'){
      g3.drawLine(210,210,390,390);
      g3.drawLine(210,390,390,210);
    }
    if (board[2][1] == 'X'){
      g3.drawLine(410,210,590,390);
      g3.drawLine(410,390,590,210);
    }

    //  top row
    if (board[0][2] == 'X'){
      g3.drawLine(10,10,190,190);
      g3.drawLine(10,190,190,10);
    }
    if (board[1][2] == 'X'){
      g3.drawLine(210,10,390,190);
      g3.drawLine(210,190,390,10);
    }
    if (board[2][2] == 'X'){
      g3.drawLine(410,10,590,190);
      g3.drawLine(410,190,590,10);
    }

    //  drawing O's
    g3.setColor(Color.BLUE);

    //  bottom row
    if (board[0][0] == 'O'){
      g3.drawOval(10,410,180,180);
    }
    if (board[1][0] == 'O'){
      g3.drawOval(210,410,180,180);
    }
    if (board[2][0] == 'O'){
      g3.drawOval(410,410,180,180);
    }

    //  middle row
    if (board[0][1] == 'O'){
      g3.drawOval(10,210,180,180);
    }
    if (board[1][1] == 'O'){
      g3.drawOval(210,210,180,180);
    }
    if (board[2][1] == 'O'){
      g3.drawOval(410,210,180,180);
    }

    //  top row
    if (board[0][2] == 'O'){
      g3.drawOval(10,10,180,180);
    }
    if (board[1][2] == 'O'){
      g3.drawOval(210,10,180,180);
    }
    if (board[2][2] == 'O'){
      g3.drawOval(410,10,180,180);
    }




  }  //  end of paint component

}  //  end of program
