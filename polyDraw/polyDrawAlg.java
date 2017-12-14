//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  14 December 2017
//Last edited:  14 December 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     FINAL
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
    double x = -3.5;
    double y;
    boolean go = false;
    double xscaled;
    double yscaled;
    double speed;

    //  history of past coordinates
    int xHist[] = new int[20000];
    int yHist[] = new int[20000];


    //  start
    public void start(){
        go = true;
    }

    //  maths
    //  y = x^3 + 3x^2 - x - 3


    public void maths(){
        //  the actual function we want to paint
    y = -((x*x*x)+(3*(x*x)-x-3));
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
        g2.drawString("-4.0", 215,40);
        g2.drawString("-3.0", 215,80);
        g2.drawString("-2.0", 215,120);
        g2.drawString("-1.0", 215,160);

        g2.drawString("1.0", 215,240);
        g2.drawString("2.0", 215,280);
        g2.drawString("3.0", 215,320);
        g2.drawString("4.0", 215,360);


        g2.drawLine(0,200,400,200);  //  x
        g2.drawString("-1.0", 150,215);
        g2.drawString("-2.0", 110,215);
        g2.drawString("-3.0", 70,215);
        g2.drawString("-4.0", 30,215);

        g2.drawString("1.0", 230,215);
        g2.drawString("2.0", 270,215);
        g2.drawString("3.0", 310,215);
        g2.drawString("4.0", 340,215);


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

    public void initSpeed(double sp){
        speed = sp * 0.007;
    }

    public void updateC(){
        if(t<=19999 || x<=4){                             //  restrict the period
        t = t+1;
        x = x + speed;
    }
    else{
        go = false;
    }
        maths();
    }  //  end of update

    public void reset(){
        x = -3.5;
        t = 0;
    }  //  end of reset


//  return the values of X and Y, note that Y must be returned in negative.
    public String returnXC(){
        String XC = String.format("%.02f", x);
        return XC;
    }  //  end of return XC

    public String returnYC(){
        String YC = String.format("%.02f", -y);
        return YC;
    }  //  end of return YC
}
