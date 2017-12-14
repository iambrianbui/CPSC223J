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
//  Handle boolean values and redrawing the program.


//Tier 3

//  600 x 400
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import java.util.*;

class Graphicpanelclass extends JPanel{

    double velocity = 30;
    double scale = 40;

    int polarx = 200;
    int polary = 200;

    int t = 0;
    double functions;
    double x = -5;
    double y;
    boolean go = false;
    double xscaled;
    double yscaled;

    //  history of past coordinates
    int xHist[] = new int[720];
    int yHist[] = new int[720];


    //  start
    public void start(){
        go = true;
    }

    //  maths
    //  y = x^3 + 3x^2 - x - 3


    public void maths(){
        //  the actual function we want to paint
    y = -((x*x*x)+(3*(x*x)-x-3));
        //  converting back to cartesian
        //  multiply by the scale
    xscaled = scale*x;
    yscaled = scale*y;
    if(t<=720){
    xHist[t] = (int)xscaled;
    yHist[t] = (int)yscaled;
}


}


    protected void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D)g;

        //  grid
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3f));

        g2.drawLine(200,0,200,400);  //  y
        g2.drawLine(0,200,400,200);  //  x

        //  ticks
        g2.setStroke(new BasicStroke(1f));
        for (int i = 0; i<401; i++){
            g2.drawLine(196,i,204,i);
            i+=39;
        }
        for (int i = 0; i<401; i++){
            g2.drawLine(i,196,i,204);
            i+=39;
        }

        if(go == true){
            g.setColor(Color.RED);
            for(int i = 0; i<t; i++){
                g.fillOval((int)xHist[i]+polarx,(int)yHist[i]+polary,6,6);
            }
            updateC();
            g.fillOval((int)xscaled+polarx,(int)yscaled+polary,6,6);
            System.out.println(+(y));

        }
    }  //  end of paintComponent


    public void updateC(){
        if(t<=720){                             //  restrict the period
        t = t+1;
        x = x + 0.025;
    }
    else{
        go = false;
    }
        maths();
    }

}
