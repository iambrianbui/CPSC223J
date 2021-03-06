//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  3 October 2017
//Last edited:  12 October 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     #3
//Due date:

//Purpose of this program:
//This program will simulate a traffic light and utilize timers to have
//the lights flicker at different times, prompted by the user to go faster
//or slower.

//File name:  trafficLightUI.java
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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.Timer;
import java.lang.Math;

//  declarations
public class trafficLightUI extends JFrame{
  //  150x150 circles, 400 width
  //  620 height

  private final int frameWidth = 400;
  private final int frameHeight = 620;

  private JPanel titlePanel;                       //  1
  private JLabel frameLabel;

  private JLabel radioInstructions;
  private JRadioButton slowBack;
  private JRadioButton medBack;
  private JRadioButton fastBack;
  private ButtonGroup backgroundButtons;

  private JPanel buttonPanel;                     //  3
  private JButton startButton;
  private JButton pauseButton;
  private JButton exitButton;

  private JPanel dummy1;
  private JPanel dummy2;

  private Graphicpanelclass graphicPanel;         //  2

  private Timer message_controller;                 //  actual timer function

  //  timer parameters
  private final double minimum_speed_allowed = 0.0000001;
  private int length_of_initial_delay;

  private FlowLayout simpleFlow;
  private GridLayout bottomLayout;

  public trafficLightUI(){
    //  frame properties
    super("Traffic Light");
    simpleFlow = new FlowLayout();
    bottomLayout = new GridLayout(3,3);
    setLayout(simpleFlow);
    setSize(frameWidth, frameHeight);
    setLocationRelativeTo(null);

    //  first panel:  title panel
    titlePanel = new JPanel();
    titlePanel.setSize(frameWidth, 30);
    Color greyBG = new Color(0x93, 0x93, 0x93);
    titlePanel.setBackground(greyBG);
    titlePanel.setLayout(simpleFlow);
    frameLabel = new JLabel();
    frameLabel.setText("Traffic Light, by Brian Bui");
    frameLabel.setForeground(Color.blue);
    titlePanel.add(frameLabel);

    //  second panel:  graphic panel
    Dimension graphicPanelSize = new Dimension(200, 470);
    graphicPanel = new Graphicpanelclass();
    graphicPanel.setPreferredSize(graphicPanelSize);
    graphicPanel.setMinimumSize(graphicPanel.getPreferredSize());
    Color goldenrod = new Color(0xcd, 0x95, 0x0c);
    graphicPanel.setBackground(goldenrod);

    //  third panel:  buttons and such
    buttonPanel = new JPanel();
    buttonPanel.setLayout(bottomLayout);

    startButton = new JButton("Start");
    buttonPanel.add(startButton);
    pauseButton = new JButton("Pause");
    buttonPanel.add(pauseButton);
    exitButton = new JButton("Exit");
    buttonPanel.add(exitButton);

    //  radio sections
    dummy1 = new JPanel();
    buttonPanel.add(dummy1);

    radioInstructions = new JLabel("Rate of Change:");

    slowBack = new JRadioButton("Slow", false);
    medBack = new JRadioButton("Medium", false);
    fastBack = new JRadioButton("Fast", false);
    backgroundButtons = new ButtonGroup();
    backgroundButtons.add(slowBack);
    backgroundButtons.add(medBack);
    backgroundButtons.add(fastBack);
    buttonPanel.add(radioInstructions);

    dummy2 = new JPanel();
    buttonPanel.add(dummy2);

    buttonPanel.add(slowBack);
    buttonPanel.add(medBack);
    buttonPanel.add(fastBack);

//  attaching
    add(titlePanel);
    add(graphicPanel);
    add(buttonPanel);

    //  handlers and listeners
    buttonhandler bhandle = new buttonhandler();
    startButton.addActionListener(bhandle);
    pauseButton.addActionListener(bhandle);
    exitButton.addActionListener(bhandle);

    radiohandler rlistener = new radiohandler();
    slowBack.addItemListener(rlistener);
    medBack.addItemListener(rlistener);
    fastBack.addItemListener(rlistener);

    length_of_initial_delay = (int)2000;
    message_controller = new Timer(length_of_initial_delay, bhandle);

}  //  end of constructor

//  initial time delays
int t1 = 1000, t2 = 3000, t3 = 4000;

private class radiohandler implements ItemListener{
  public void itemStateChanged(ItemEvent event){
    if(slowBack.isSelected()){
      t1 = 1000;  //  yellow
      t2 = 3000;  //  GREEN
      t3 = 4000;  //  red
      //  don't ask me why it's in this order
    }
    if(medBack.isSelected()){
      t1 = 500;
      t2 = 1500;
      t3 = 2000;
    }
    if(fastBack.isSelected()){
      t1 = 250;
      t2 = 750;
      t3 = 1000;
    }
  }
}

//  buttons
private class buttonhandler implements ActionListener{
  public int index = 0;
  public void actionPerformed(ActionEvent event){
      //  power on
    if (event.getSource()==startButton){
      message_controller.start();
      graphicPanel.power = true;
    }
      //  pause
    else if (event.getSource()==pauseButton){
      message_controller.stop();
    }
      //  exit
    else if (event.getSource()==exitButton){
      System.exit(0);
    }
      //  traffic handling
    else if (event.getSource()==message_controller){
      index = graphicPanel.getIndex();
      switch(index){
        case 0: message_controller.setDelay(t1);
        break;
        case 1: message_controller.setDelay(t2);
        break;
        case 2: message_controller.setDelay(t3);
        break;
      }
      repaint();
    }
  }
}  //  end of actionlistener


}
