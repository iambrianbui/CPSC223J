//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  29 August 2017
//Last edited:  30 August 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     #1
//Due date:

//Purpose of this program:
//This program will demonstrate drawing three different geometric shapes in 3
//different colors, prompted by buttons.

//File name:  shapeGenMain.java
//Purpose of this specific source file:
//  Activate the UI and set basic properties of size and action on exit,
//  orchestrate the code.

//Tier 1

import javax.swing.JFrame;

public class shapeGenMain
{public static void main(String[] args)
   {System.out.println("The main function has begun executing.");
    shapeGenUI user = new shapeGenUI();
    user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    user.setVisible(true);
    System.out.println("The main function will terminate soon.");
   }//End main
}//End class Usermain
