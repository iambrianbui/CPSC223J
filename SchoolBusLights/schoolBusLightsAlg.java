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
//  Handle boolean values and redrawing the program.

//Tier 3

import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Graphicpanelclass extends JPanel{
    boolean power = false;                  //  power status
    int index = 0;                          //  for the switch statement
    int counter = 0;                        //  for the 100 counter limit

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //  circles
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(4f));
        g2.drawOval(43,28,160,160);
        g2.drawOval(211,28,160,160);

        //  fills
        g2.setColor(Color.GRAY);
        g2.fillOval(43,28,160,160);
        g2.fillOval(211,28,160,160);

        //  if power is on
        if (power==true){
            switch(index){
                case 0: g2.setColor(Color.RED);
                g2.fillOval(43,28,160,160);
                counter++;
                System.out.println(+counter);
                checkCounter();
                break;

                case 1: g2.setColor(Color.RED);
                g2.fillOval(211,28,160,160);
                break;
            }
            index = (index+1)%2;
        }
    }  //  end of paintComponent

    //  check if we are at 100
    private void checkCounter(){
        if (counter==100){
        power = false;
        counter = 0;
    }
    }

    //  get the index of the switch
    public int getIndex(){
        return index;
    }

    //  is the power on?
    public boolean getPower(){
        return power;
    }
}  //  end of Graphicpanelclass
