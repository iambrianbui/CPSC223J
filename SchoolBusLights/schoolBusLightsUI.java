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
//  Draw and show the UI.

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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.Timer;
import java.lang.Math;

//  declarations
public class schoolBusLightsUI extends JFrame{
    //  160x160 circles, 400 x 600 frame should do
    private final int frameWidth = 400;
    private final int frameHeight = 600;
    public String text = "Start";

    private JPanel titlePanel;                  //  1
    private JLabel frameLabel;

    private JRadioButton fiveBack;
    private JRadioButton threeBack;
    private JRadioButton oneBack;
    private JRadioButton floatBack;
    private ButtonGroup backgroundButtons;

    private JPanel buttonPanel;                 //  3
    private JButton startpauseButton;
    private JButton exitButton;

    private JPanel dummy1;
    private JPanel dummy2;

    private Graphicpanelclass graphicPanel;     //  2

    private Timer message_controller;

    //  timer parameters
    private final double minimum_speed_allowed = 0.0000001;
    private int length_of_initial_delay;

    private FlowLayout simpleFlow;
    private GridLayout bottomLayout;

    //  let's boogie
    public schoolBusLightsUI(){
        //  frame properties
        super("School Bus Lights");
        simpleFlow = new FlowLayout();
        bottomLayout = new GridLayout(2,4);
        setLayout(simpleFlow);
        setSize(frameWidth,frameHeight);
        setLocationRelativeTo(null);

        //  first panel:  titlePanel
        titlePanel = new JPanel();
        titlePanel.setSize(frameWidth, 30);
        Color greyBG = new Color(0x93, 0x93, 0x93);
        titlePanel.setBackground(greyBG);
        titlePanel.setLayout(simpleFlow);
        frameLabel = new JLabel();
        frameLabel.setText("School Bus Lights by Brian Bui");
        frameLabel.setForeground(Color.blue);
        titlePanel.add(frameLabel);

        //  second panel:  graphic panel
        Dimension graphicPanelSize = new Dimension(400,400);
        graphicPanel = new Graphicpanelclass();
        graphicPanel.setPreferredSize(graphicPanelSize);
        graphicPanel.setMinimumSize(graphicPanel.getPreferredSize());
        Color goldenrod = new Color(0xcd, 0x95, 0x0c);
        graphicPanel.setBackground(goldenrod);

        //  third panel:  buttons and such
        buttonPanel = new JPanel();
        buttonPanel.setLayout(bottomLayout);

        dummy1 = new JPanel();
        buttonPanel.add(dummy1);

        startpauseButton = new JButton(text);
        buttonPanel.add(startpauseButton);
        exitButton = new JButton("Exit");
        buttonPanel.add(exitButton);

        dummy2 = new JPanel();
        buttonPanel.add(dummy2);

        //  radio sections
        fiveBack = new JRadioButton("5.0 sec", false);
        threeBack = new JRadioButton("3.0 sec", false);
        oneBack = new JRadioButton("1.0 sec", false);
        floatBack = new JRadioButton("0.06 sec", false);

        //  in hindsight, i don't think i needed these
        backgroundButtons = new ButtonGroup();
        backgroundButtons.add(fiveBack);
        backgroundButtons.add(threeBack);
        backgroundButtons.add(oneBack);
        backgroundButtons.add(floatBack);

        //  add to panel
        buttonPanel.add(fiveBack);
        buttonPanel.add(threeBack);
        buttonPanel.add(oneBack);
        buttonPanel.add(floatBack);

        //  attaching
        add(titlePanel);
        add(graphicPanel);
        add(buttonPanel);

        //  handlers and listeners
        buttonhandler bhandle = new buttonhandler();
        startpauseButton.addActionListener(bhandle);
        exitButton.addActionListener(bhandle);

        radiohandler rlistener = new radiohandler();
        fiveBack.addItemListener(rlistener);
        threeBack.addItemListener(rlistener);
        oneBack.addItemListener(rlistener);
        floatBack.addItemListener(rlistener);

        length_of_initial_delay = (int)2000;
        message_controller = new Timer(length_of_initial_delay, bhandle);
    }  //  end of constructor

    int t = 1000;  //  default time
    //  radio buttons
    private class radiohandler implements ItemListener{
        public void itemStateChanged(ItemEvent event){
            if(fiveBack.isSelected()){
                t = 5000;
            }
            if(threeBack.isSelected()){
                t = 3000;
            }
            if(oneBack.isSelected()){
                t = 1000;
            }
            if(floatBack.isSelected()){
                t = 60;
            }
        }
    }
    public boolean resume = true;

    //  buttons and timer
    private class buttonhandler implements ActionListener{
        public int index = 0;
        public boolean power = false;
        public void actionPerformed(ActionEvent event){
            power = graphicPanel.getPower();
            //  power on
            if (event.getSource()==startpauseButton){
                if (power == false){
                    message_controller.start();
                    graphicPanel.power = true;
                    text = "Pause";
                }
                //  or pause the timer
                else if (resume == true){
                    resume = false;
                    message_controller.stop();
                    text = "Resume";
                }
                //  or resume the timer
                else if (resume == false){
                    resume = true;
                    message_controller.start();
                    text = "Pause";
            }
            startpauseButton.setText(text);

            }  //  end of startpauseButton
            else if (event.getSource()==exitButton){
                System.exit(0);
            }  //  end of exitButton

            //  actual lights
            else if (event.getSource()==message_controller){
                index = graphicPanel.getIndex();
                switch(index){
                    case 0:  message_controller.setDelay(t);
                    break;
                    case 1:  message_controller.setDelay(t);
                    break;
                }
                repaint();
            }
        }
    }

}  //  end of schoolBusLightsUI
