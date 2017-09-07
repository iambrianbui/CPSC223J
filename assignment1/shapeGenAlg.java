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
  //  initialize boolean values, will act like "switches"
  boolean showcircle = false;
  boolean showrect = false;
  boolean showtri = false;

  boolean showred = false;
  boolean showgreen = false;
  boolean showblue = false;

  public void changeCircle(){
    showcircle = true;
    showrect = false;
    showtri = false;
    System.out.println("Circle");
  }

  public void changeRect(){
    showcircle = false;
    showrect = true;
    showtri = false;
  }

  public void changeTri(){
    showcircle = false;
    showrect = false;
    showtri = true;
  }

  public void pickRed(){
    showred = true;
    showgreen = false;
    showblue = false;
    System.out.println("Red");
  }

  public void pickGreen(){
    showred = false;
    showgreen = true;
    showblue = false;
    System.out.println("Green");
  }

  public void pickBlue(){
    showred = false;
    showgreen = false;
    showblue = true;
    System.out.println("Blue");
  }

  public void clearAll(){  //  clear all the colors and shapes
    showred = false;
    showgreen = false;
    showblue = false;

    showcircle = false;
    showrect = false;
    showtri = false;

    System.out.println("Clear.");

  }


  protected void paintComponent(Graphics g){
    System.out.println("Finding...");
    super.paintComponent(g);
    Graphics2D g2=(Graphics2D)g;
    g2.setStroke(new BasicStroke(4f));

    //  all the reds
    if (showred==true){
      g.setColor(Color.RED);
      //  circle
      if (showcircle==true){
        g.drawOval(400,400,200,200);
      }
      //  Rectangle
      else if (showrect==true){
        g.drawRect(400,400,200,100);
      }
      //  Triangle
      else if (showtri==true){
        g.drawLine(200,200,400,400);
        g.drawLine(400,400,200,400);
        g.drawLine(200,400,200,200);
      }
    }
      //  all the greens
      else if (showgreen==true){
        g.setColor(Color.GREEN);
        //  circle
        if (showcircle==true){
          g.drawOval(400,400,200,200);
        }
        //  Rectangle
        else if (showrect==true){
          g.drawRect(400,400,200,100);
        }
        //  Triangle
        else if (showtri==true){
          g.drawLine(200,200,400,400);
          g.drawLine(400,400,200,400);
          g.drawLine(200,400,200,200);
        }
      }
        //  all the blues
        else if (showblue==true){
          g.setColor(Color.BLUE);
          //  circle
          if (showcircle==true){
            g.drawOval(400,400,200,200);
          }
          //  Rectangle
          else if (showrect==true){
            g.drawRect(400,400,200,100);
          }
          //  Triangle
          else if (showtri==true){
            g.drawLine(200,200,400,400);
            g.drawLine(400,400,200,400);
            g.drawLine(200,400,200,200);
          }
        }

  }



}
