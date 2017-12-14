//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  21 November 2017
//Last edited:  21 November 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     #5
//Due date:

//Purpose of this program:
//This program will draw a curve given the formula.

//File name:  polyDrawMain.java
//Purpose of this specific source file:
//  Activate the UI and set basic properties of size and action on exit,
//  orchestrate the code.

//Tier 1

import javax.swing.JFrame;

public class polyDrawMain{
    public static void main(String[] args){
        System.out.println("The main function has began executing.");
        polyDrawUI user = new polyDrawUI();
        user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        user.setVisible(true);
        System.out.println("The main function will terminate soon.");
    }  //  end main
}
