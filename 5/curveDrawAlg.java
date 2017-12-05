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

import java.util.*;

class Graphicpanelclass extends JPanel{

    double velocity = 30;
    double scale = 25;

    int polarx = 200;
    int polary = 200;

    int t = 0;
    double rad = 0;
    double functions;
    double x;
    double y;
    double radicalR = 0;
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
    //  r = cos4t
    //  sqrt(x^2+y^2) = cos(y/x)
    //


    public void maths(){
        //  the actual function we want to paint
    functions = (-4 * Math.cos(4*rad));
        //  converting back to cartesian
    x = (radicalR + functions) * Math.cos(rad);
    y = (radicalR + functions) * Math.sin(rad);
        //  multiply by the scale
    xscaled = scale*x;
    yscaled = scale*y;
        //  update arrays
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

        g2.drawOval(150,150,100,100);
        g2.drawOval(100,100,200,200);
        g2.drawOval(50,50,300,300);

        if(go == true){
            g.setColor(Color.RED);
            for(int i = 0; i<t; i++){
                g.fillOval((int)xHist[i]+polarx,(int)yHist[i]+polary,6,6);
            }
            updateC();
            g.fillOval((int)xscaled+polarx,(int)yscaled+polary,6,6);
            System.out.println(+(xscaled+polarx));
        }
    }  //  end of paintComponent


    public void updateC(){
        if(t<=720){                             //  restrict the period
        t =  t+1;
    }
    else{
        go = false;
    }
        rad = (t*3.14159)/180;
        maths();
    }

}
