//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  17 October 2017
//Last edited:  17 October 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     MIDTERM
//Due date:

//Purpose of this program:
//This program will simulate a school bus's emergency lights, two lights that
//flash in an alternating fashion.

//File name:  schoolBusLightsMain.java
//Purpose of this specific source file:
//  Activate the UI and set basic properties of size and action on exit,
//  orchestrate the code.

//Tier 1

import javax.swing.JFrame;

public class schoolBusLightsMain
{public static void main(String[] args)
   {System.out.println("The main function has begun executing.");
    schoolBusLightsUI user = new schoolBusLightsUI();
    user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    user.setVisible(true);
    System.out.println("The main function will terminate soon.");
   }//End main
}//End class Usermain
