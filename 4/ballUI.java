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

//File name:  ballUI.java
//Purpose of this specific source file:
//  Draw and show the UI

//Tier 2

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.Timer;
import java.lang.Math;

public class ballUI extends JFrame{
    //  300 x 400 graphicpanel
    //  600 total height

    private final int frameHeight = 600;
    private final int frameWidth = 600;

    private JPanel titlePanel;                          //  1
    private JLabel frameLabel;

    private JPanel buttonPanel;                         //  3
    private JButton startButton;
    private JButton exitButton;
    private JLabel speedText;
    private JTextField textSpeed;
    private JLabel angleText;
    private JTextField textAngle;

    private JLabel mathPrompt;
    private JLabel javaPrompt;
    private JLabel javaCoord;
    private String jC = "0, 0";
    private JLabel mathCoord;
    private String mC = "0, 0";

    private Graphicpanelclass graphicPanel;             //  2

    Timer refreshClock;
    Timer motionClock;
    double xDirection;
    double yDirection;
    double refreshFPS = 24;                             //  Hz FPS
    int refreshClockDelayInt;
    double motionClockRate = 20;                        //  How many updates per second
    int motionClockDelayInt;
    final double msPerSec = 1000;

    public String startButtonText = "Start";


    private FlowLayout simpleFlow;
    private GridLayout bottomGrid;

    public ballUI(){
        //  frame properties
        super("Ball");
        simpleFlow = new FlowLayout();
        bottomGrid = new GridLayout(5,3);
        setLayout(simpleFlow);
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);

        //  first panel:  title panel
        titlePanel = new JPanel();
        titlePanel.setSize(frameWidth, 40);
        Color greyBG = new Color(0x93, 0x93, 0x93);
        titlePanel.setBackground(greyBG);
        titlePanel.setLayout(simpleFlow);
        frameLabel = new JLabel();
        frameLabel.setText("Ball, by Brian Bui");
        frameLabel.setForeground(Color.blue);
        titlePanel.add(frameLabel);

        //  second panel:  graphic panel
        Dimension graphicPanelSize = new Dimension(600, 400);
        graphicPanel = new Graphicpanelclass();
        graphicPanel.setPreferredSize(graphicPanelSize);
        graphicPanel.setMinimumSize(graphicPanel.getPreferredSize());
        graphicPanel.setBackground(greyBG);

        //  third panel:  buttons and such
        buttonPanel = new JPanel();
        buttonPanel.setLayout(bottomGrid);

        speedText = new JLabel();
        speedText.setText("Speed:  ");
        buttonPanel.add(speedText);
        textSpeed = new JTextField(4);
        buttonPanel.add(textSpeed);

        angleText = new JLabel();
        angleText.setText("Angle:  ");
        buttonPanel.add(angleText);
        textAngle = new JTextField(6);
        buttonPanel.add(textAngle);

        javaPrompt = new JLabel();
        javaPrompt.setText("Java Coordinates of ball:  ");
        buttonPanel.add(javaPrompt);

        javaCoord = new JLabel();
        javaCoord.setText(jC);
        buttonPanel.add(javaCoord);

        mathPrompt = new JLabel();
        mathPrompt.setText("Math Coordinates of ball:  ");
        buttonPanel.add(mathPrompt);

        mathCoord = new JLabel();
        mathCoord.setText(mC);
        buttonPanel.add(mathCoord);

        startButton = new JButton(startButtonText);
        buttonPanel.add(startButton);
        exitButton = new JButton("Exit");
        buttonPanel.add(exitButton);

        //  attaching
        add(titlePanel);
        add(graphicPanel);
        add(buttonPanel);

        //  handlers and listeners
        buttonhandler bhandle = new buttonhandler();
        startButton.addActionListener(bhandle);
        exitButton.addActionListener(bhandle);

        clockhandler chandle = new clockhandler();

        //  refresh clock
        refreshClockDelayInt = (int)Math.round(msPerSec/refreshFPS);
        refreshClock = new Timer(refreshClockDelayInt, chandle);

        //  motion clock
        motionClockDelayInt = (int)Math.round(msPerSec/motionClockRate);
        motionClock = new Timer(motionClockDelayInt, chandle);

    }  //  end of constructor

//  buttons
int index = 0;

private class buttonhandler implements ActionListener{
    public void actionPerformed(ActionEvent event){
        if (event.getSource()==startButton){
            switch(index){
                case 0:
                float speed = 0;
                float angle = 0;
                String s = textSpeed.getText();
                try{
                    speed = Float.parseFloat(s);
                } catch(NumberFormatException e){
                    System.out.println("not a float");
                }
                s = textAngle.getText();
                try{
                    angle = Float.parseFloat(s);
                } catch(NumberFormatException e){
                    System.out.println("not a float, angle");
                }
                graphicPanel.initSpeedAngle(speed, angle);
                graphicPanel.initBall();
                repaint();
                refreshClock.start();
                motionClock.start();

                startButtonText = "Pause";
                startButton.setText(startButtonText);
                index = 1;

                break;

                case 1:
                refreshClock.stop();
                motionClock.stop();
                startButtonText = "Resume";
                startButton.setText(startButtonText);
                index = 2;
                break;


                case 2:
                refreshClock.start();
                motionClock.start();
                startButtonText = "Pause";
                startButton.setText(startButtonText);
                index = 1;
                break;



        }
        }
        else if(event.getSource() == exitButton){
            System.exit(0);
        }
    }
}

private class clockhandler implements ActionListener{
    public void actionPerformed(ActionEvent event){
        boolean result = false;
        if(event.getSource()==refreshClock){
            repaint();
            javaCoord.setText(graphicPanel.returnJC());
            mathCoord.setText(graphicPanel.returnMC());
        }

        else if(event.getSource()==motionClock){
            result = graphicPanel.moveBall();
            if (result)
                repaint();
            else{
                motionClock.stop();
                refreshClock.stop();
                index = 0;
                startButtonText = "Start";
                startButton.setText(startButtonText);
                System.out.println("123");

            }
        }  //  motion clock
    }  //  end of action performed
}  //  end of clockhandler



}  // end
