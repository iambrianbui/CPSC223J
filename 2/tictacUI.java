//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  14 September 2017
//Last edited:  21 September 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     #2
//Due date:

//Purpose of this program:
//This program will simulate a tic tac toe game and use radio buttons to
//determine the first player's selection.
//Graphics will be used to draw and simulate the playing field.

//File name:  tictacUI.java
//Purpose of this specific source file:
//  Draw up the UI and handle the button/action handlers

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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.Graphics;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Point;

//  declarations
public class tictacUI extends JFrame{

//  900 width definitely, for the 300x300 squares, 900 minimum height
//  900 + 40 + 200
//  define dimensions
private final int frameWidth = 600;
private final int frameHeight = 740;

private JPanel titlePanel;
private JLabel frameLabel;

private JLabel radioInstructions;
private JRadioButton Xback;
private JRadioButton Oback;
private ButtonGroup backgroundButtons;

private JPanel buttonPanel;
private JButton newGameButton;
private JButton exitButton;

private Graphicpanelclass graphicPanel;

private FlowLayout simpleFlow;
private GridLayout midLayout, bottomLayout;

private MouseListener minnieMouse = new mousehandler();

public tictacUI(){

  //  frame properties
  super("Tic Tac Toe");
  simpleFlow = new FlowLayout();
  midLayout = new GridLayout(3,3);
  bottomLayout = new GridLayout(1,5);
  setLayout(simpleFlow);
  setSize(frameWidth, frameHeight);
  setLocationRelativeTo(null);

  //  first panel:  information panel
  titlePanel = new JPanel();
  titlePanel.setSize(frameWidth, 40);
  Color greyBG = new Color(0x93,0x93,0x93);
  titlePanel.setBackground(greyBG);
  titlePanel.setLayout(simpleFlow);
  frameLabel = new JLabel();
  frameLabel.setText("Tic Tac Toe, by Brian Bui");
  frameLabel.setForeground(Color.red);
  titlePanel.add(frameLabel);

  //  second panel:  graphic panel
  Dimension graphicPanelSize = new Dimension(frameWidth, 600);
  graphicPanel = new Graphicpanelclass();
  graphicPanel.setPreferredSize(graphicPanelSize);
  graphicPanel.setMinimumSize(graphicPanel.getPreferredSize());
  Color graphicalBG = new Color(0x8A,0x2B,0xE2);  //  find nicer color maybe
  graphicPanel.setBackground(graphicalBG);
  graphicPanel.addMouseListener(minnieMouse);

  //  third panel:  button/radio panel
  //  radio section
  buttonPanel = new JPanel();
  buttonPanel.setLayout(bottomLayout);
  radioInstructions = new JLabel("Pick a side:  ");
  Xback = new JRadioButton("X", false);
  Oback = new JRadioButton("O",false);
  backgroundButtons = new ButtonGroup();
  backgroundButtons.add(Xback);
  backgroundButtons.add(Oback);
  buttonPanel.add(radioInstructions);
  buttonPanel.add(Xback);
  buttonPanel.add(Oback);

  //  button section
  newGameButton = new JButton("New Game");
  buttonPanel.add(newGameButton);

  exitButton = new JButton("Quit");
  buttonPanel.add(exitButton);

  add(titlePanel);
  add(graphicPanel);
  add(buttonPanel);

  //  handlers and listeners
  buttonhandler bhandle = new buttonhandler();
  newGameButton.addActionListener(bhandle);
  exitButton.addActionListener(bhandle);

  radiohandler rlistener = new radiohandler();
  Xback.addItemListener(rlistener);
  Oback.addItemListener(rlistener);



}  //  end of constructor

//  buttons
private class buttonhandler implements ActionListener{
  public void actionPerformed(ActionEvent event){
    if (event.getSource()==newGameButton){

    }
    if (event.getSource()==exitButton){
      System.exit(0);
    }
  }
}  //  end of button definitions

//  radio
private class radiohandler implements ItemListener{
  public void itemStateChanged(ItemEvent event){
    if (Xback.isSelected()){
      System.out.println("X");
    }
    else if (Oback.isSelected()){
      System.out.println("O");
    }
  }
}

//  mouse
private class mousehandler implements MouseListener{
  public void mousePressed(MouseEvent ev){
    int mouseX = ev.getX();
    int mouseY = ev.getY();
    System.out.println(+mouseX);
    System.out.println(+mouseY);
  }

  public void mouseClicked(MouseEvent e){
    System.out.println("clicked");
   }

  //  override existing functions
  public void mouseReleased(MouseEvent e){ }
  public void mouseEntered(MouseEvent e){ }
  public void mouseExited(MouseEvent e){ }
}


}  // end of tictacUI
