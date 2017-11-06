//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  31 October 2017
//Last edited:  31 October 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     #4
//Due date:

//Purpose of this program:
//This program will simulate a ball travelling to the edges of the respective UI.

//File name:  travelingBallMain.java
//Purpose of this specific source file:
//  Activate the UI and set basic properties of size and action on exit,
//  orchestrate the code.

//Tier 1

import javax.swing.JFrame;

public class travelingBallMain
{public static void main(String[] args)
   {System.out.println("The main function has begun executing.");
    travelingBallUI user = new travelingBallUI();
    user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    user.setVisible(true);
    System.out.println("The main function will terminate soon.");
   }//End main
}//End class Usermain
