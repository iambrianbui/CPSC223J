//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  14 September 2017
//Last edited:  14 September 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     #2
//Due date:

//Purpose of this program:
//This program will simulate a tic tac toe game and use radio buttons to
//determine the first player's selection.
//Graphics will be used to draw and simulate the playing field.

//File name:  tictacMain.java
//Purpose of this specific source file:
//  Activate the UI and set basic properties of size and action on exit,
//  orchestrate the code.

//Tier 1

import javax.swing.JFrame;

public class tictacMain
{public static void main(String[] args)
   {System.out.println("The main function has begun executing.");
    tictacUI user = new tictacUI();
    user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    user.setVisible(true);
    System.out.println("The main function will terminate soon.");
   }//End main
}//End class Usermain
