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

//  party time
public class curveDrawUI extends JFrame{
    //  400 x 400 graphic panel
    //  800 total height

    //  frame
    private final int frameHeight = 700;
    private final int frameWidth = 500;

    private JPanel titlePanel;                          //  1
    private JLabel frameLabel;

    private JPanel buttonPanel;                          //  3
    private JButton startButton;
    private JButton pauseButton;
    private JButton exitButton;

    private JLabel xCoordText;
    private JLabel yCoordText;

    private Graphicpanelclass graphicPanel;             //  2

    Timer refreshClock;
    Timer motionClock;
    double refreshFPS = 24;                             //  Hz FPS
    int refreshClockDelayInt;
    double motionClockRate = 20;
    int motionClockDelayInt;
    final double msPerSec = 1000;

    private FlowLayout simpleFlow;
    private GridLayout bottomGrid;

    public curveDrawUI(){
        //  frame properties
        super("Linear Curve");
        simpleFlow = new FlowLayout();
        bottomGrid = new GridLayout(1,4);
        setLayout(simpleFlow);
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);

        //  first panel:  title panel
        titlePanel = new JPanel();
        titlePanel.setSize(frameWidth,40);
        Color greyBG = new Color (0x93,0x93,0x93);
        titlePanel.setBackground(greyBG);
        titlePanel.setLayout(simpleFlow);
        frameLabel = new JLabel();
        frameLabel.setText("Curve Draw, by Brian Bui");
        frameLabel.setForeground(Color.blue);
        titlePanel.add(frameLabel);

        //  second panel:  graphic panel
        Dimension graphicPanelSize = new Dimension(400, 400);
        graphicPanel = new Graphicpanelclass();
        graphicPanel.setPreferredSize(graphicPanelSize);
        graphicPanel.setMinimumSize(graphicPanel.getPreferredSize());
        graphicPanel.setBackground(greyBG);

        //  third panel:  buttons and such
        buttonPanel = new JPanel();
        buttonPanel.setLayout(bottomGrid);

        startButton = new JButton("Start");
        buttonPanel.add(startButton);
        exitButton = new JButton("Exit");
        buttonPanel.add(exitButton);

        //  attaching
        add(titlePanel);
        add(graphicPanel);
        add(buttonPanel);





    }


}
