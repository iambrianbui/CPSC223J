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

//File name:  curveDrawMain.java
//Purpose of this specific source file:
//  Handle boolean values and redrawing the program.


//Tier 3

//  600 x 400
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


class Graphicpanelclass extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //  grid
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3f));

        g2.drawOval(150,150,100,100);
        g2.drawOval(100,100,200,200);
        g2.drawOval(50,50,300,300);

    }
}
