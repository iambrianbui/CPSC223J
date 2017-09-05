//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  29 August 2017
//Last edited:  30 August 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     #1
//Due date:

//Purpose of this program:
//This program will demonstrate drawing three different geometric shapes in 3
//different colors, prompted by buttons.

//File name:  shapeGenUI.java
//Purpose of this specific source file:
//  Activate the UI and set basic properties of size and action on exit,
//  orchestrate the code.

//Tier 2
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Graphics;


//  declarations
public class shapeGenUI extends JFrame{

//  1600x900 frame
private final int frameWidth = 1600;
private final int frameHeight = 900;

private JPanel titlePanel;
private JLabel frameLabel;

//  buttons
private JPanel buttonPanel;  //  vessel for the buttons
private JButton circleButton;
private JButton rectButton;
private JButton triButton;

private JButton colorRedButton;
private JButton colorGreenButton;
private JButton colorBlueButton;

private JButton drawButton;
private JButton clearButton;
private JButton exitButton;

private shapeGenUI graphicPanel;

private FlowLayout simpleFlow;
private GridLayout rowLayout;

public shapeGenUI(){
  //  frame properties
  super("Shapes");
  simpleFlow = new FlowLayout();
  rowLayout = new GridLayout(1,3);  //1 by 3
  setLayout(simpleFlow);
  setSize(frameWidth, frameHeight);
  setLocationRelativeTo(null);

  //  first panel
  titlePanel = new JPanel();
  titlePanel.setSize(frameWidth,50);
  titlePanel.setBackground(java.awt.Color.white);
  titlePanel.setLayout(simpleFlow);
  frameLabel = new JLabel();
  frameLabel.setText("Shapes, by Brian Bui");
  frameLabel.setForeground(Color.red);
  titlePanel.add(frameLabel);

  //  second panel
  Dimension graphicPanelSize = new Dimension(frameWidth-100, 600);
  graphicPanel = new shapeGenUI();
  graphicPanel.setPreferredSize(graphicPanelSize);
  graphicPanel.setMinimumSize(graphicPanel.getPreferredSize());
  Color graphicalBG = new Color(0x93,0x93,0x93);
  graphicPanel.setBackground(graphicalBG);


  //  attach the panels to the frame
  add(titlePanel);
  add(graphicPanel);


}



}
