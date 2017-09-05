//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  29 August 2017
//Last edited:  5 September 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     #1
//Due date:

//Purpose of this program:
//This program will demonstrate drawing three different geometric shapes in 3
//different colors, prompted by buttons.

//File name:  shapeGenAlg.java
//Purpose of this specific source file:
//  Activate the UI and set basic properties of size and action on exit,
//  orchestrate the code.

//Tier 3
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
class Graphicpanelclass extends JPanel{
  boolean showcircle = false;
  boolean showrect = false;
  boolean showtri = false;

  public void changecircle(){
    showcircle = !showcircle;
    showrect = false;
    showtri = false;
    System.out.println("Hey it works!");
  }

  protected void paintComponent(Graphics g){
    if(showcircle=true){
    super.paintComponent(g);
    g.setColor(Color.BLUE);
    g.drawRect(20,10,200,100);
  }
  }



}
