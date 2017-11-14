//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  31 October 2017
//Last edited:  13 November 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     #4
//Due date:

//Purpose of this program:
//This program will simulate a ball travelling to the edges of the respective UI.

//File name:  ballAlg.java
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

    double ballCentX;
    double ballCentY;
    double ballUCX;
    double ballUCY;
    double ballRadius = 8;
    double ballDia = 2*ballRadius;
    boolean motion = false;
    double speed = 0;
    double angle = 0;
    double dx = 0;
    double dy = 0;


    protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

    //  grid
    g2.setColor(Color.BLACK);
    g2.setStroke(new BasicStroke(3f));

    g2.drawLine(300,0,300,400);
    g2.drawLine(0,200,600,200);
    g2.setStroke(new BasicStroke(1f));
    for (int i = 0; i<401; i++){
        g2.drawLine(296,i,304,i);
        i+=9;
    }
    for (int i = 0; i<601; i++){
        g2.drawLine(i,196,i,204);
        i+=9;
    }

    if (motion == true){
        g2.setColor(Color.RED);
        g2.fillOval((int)ballUCX, (int)ballUCY, (int)ballDia, (int)ballDia);
    }

}  //  end of paintComponent

    public void initSpeedAngle(float sp, float an){
        speed = sp;
        angle = an;
        angle = Math.toRadians(an);
        dx = speed * Math.cos(angle);
        dy = speed * Math.sin(angle);
        System.out.println(angle);

    }

    public void initBall(){
        ballCentX = 300;
        ballCentY = 200;
        ballUCX = ballCentX - ballRadius;
        ballUCY = ballCentY - ballRadius;
        motion = true;

    }  //  end of initBall

    public boolean moveBall(){
        boolean successfulMove = false;
        if (ballCentX+ballRadius>=0.0 && ballCentY+ballRadius>=0.0 && ballCentX-ballRadius<=600 && ballCentY-ballRadius<=400){
            ballCentX = ballCentX + dx;
            ballCentY = ballCentY - dy;
            ballUCX = ballCentX - ballRadius;
            ballUCY = ballCentY - ballRadius;
            successfulMove=true;
        }
        return successfulMove;
    }

    public String returnJC(){
        String X = String.format("%.02f", ballCentX);
        String Y = String.format("%.02f", ballCentY);
        String s = X + ", " + Y;
        return s;
    }

    public String returnMC(){
        double MX = (ballCentX-300)/10;
        double MY = (ballCentY-200)/-10;
        String X = String.format("%.02f", MX);
        String Y = String.format("%.02f", MY);
        String s = X + ", " + Y;;
        return s;
    }



}  //  end of Graphicpanelclass
