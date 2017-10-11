//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  3 October 2017
//Last edited:  3 October 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     #3
//Due date:

//Purpose of this program:
//This program will simulate a traffic light and utilize timers to have
//the lights flicker at different times, prompted by the user to go faster
//or slower.

//File name:  trafficLightUI.java
//Purpose of this specific source file:
//  Handle boolean values and redrawing the program.

//Tier 3

import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Graphicpanelclass extends JPanel{
  int index = 0;


  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

    //  circles
    g2.setColor(Color.BLACK);
    g2.setStroke(new BasicStroke(3f));
    g2.drawOval(28,3,150,150);
    g2.drawOval(28,158,150,150);
    g2.drawOval(28,313,150,150);

    switch(index){
      case 0: g2.setColor(Color.RED);
      g2.fillOval(28,3,150,150);
      break;
      case 1: g2.setColor(Color.YELLOW);
      g2.fillOval(28,158,150,150);
      break;
      case 2: g2.setColor(Color.GREEN);
      g2.fillOval(28,313,150,150);
      break;
    }
    index = (index+1)%3;
  }
  public int getIndex(){
    return index;
  }

}  //  end of graphic panel class
