//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  14 September 2017
//Last edited:  28 September 2017
//Course:         Cpsc 223J
//Semester:       2017 Fall
//Assignment:     #2
//Due date:  28 September 2017

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

//  900 width, for the 300x300 squares, 900 minimum height
//  900 + 40 + 200
//  define dimensions
//  because of my chromebook resolution, 600x600 playing field
private final int frameWidth = 600;
private final int frameHeight = 760;

private JPanel titlePanel;  //  1
private JPanel infoPanel;
private JLabel frameLabel;  //  3
private JLabel infoLabel;

private JLabel radioInstructions;
private JRadioButton Xback;
private JRadioButton Oback;
private ButtonGroup backgroundButtons;

private JPanel buttonPanel;  //  4
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

  //  first panel:  title panel
  titlePanel = new JPanel();
  titlePanel.setSize(frameWidth, 30);
  Color greyBG = new Color(0x93,0x93,0x93);
  titlePanel.setBackground(greyBG);
  titlePanel.setLayout(simpleFlow);
  frameLabel = new JLabel();
  frameLabel.setText("Tic Tac Toe, by Brian Bui");
  frameLabel.setForeground(Color.red);
  titlePanel.add(frameLabel);

  //  third panel:  graphic panel
  Dimension graphicPanelSize = new Dimension(frameWidth, 600);
  graphicPanel = new Graphicpanelclass();
  graphicPanel.setPreferredSize(graphicPanelSize);
  graphicPanel.setMinimumSize(graphicPanel.getPreferredSize());
  Color graphicalBG = new Color(0x84,0xE1,0x84);  //  find nicer color maybe
  graphicPanel.setBackground(graphicalBG);
  graphicPanel.addMouseListener(minnieMouse);

  //  second panel:  infor panel
  infoPanel = new JPanel();
  infoPanel.setSize(frameWidth, 30);
  infoPanel.setLayout(simpleFlow);
  infoLabel = new JLabel();
  infoLabel.setText(graphicPanel.getText());
  infoPanel.add(infoLabel);

  //  fourth panel:  button/radio panel
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

  //  putting it in order
  add(titlePanel);
  add(graphicPanel);
  add(infoPanel);
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
      graphicPanel.newGame();
      backgroundButtons.clearSelection();
      repaint();
      infoLabel.setText(graphicPanel.getText());
    }
    if (event.getSource()==exitButton){
      System.exit(0);
    }
  }
}  //  end of button definitions

//  radio buttons
private class radiohandler implements ItemListener{
  public void itemStateChanged(ItemEvent event){
    if (Xback.isSelected()){
      System.out.println("X");
      graphicPanel.Xfirst();
    }
    else if (Oback.isSelected()){
      System.out.println("O");
      graphicPanel.Ofirst();
    }
  }
}  //  end of radio buttons

//  mouse
private class mousehandler implements MouseListener{
  public void mousePressed(MouseEvent ev){
    int mouseX = ev.getX();
    int mouseY = ev.getY();
    // System.out.println(+mouseX);
    // System.out.println(+mouseY);

    //  first column
    if (mouseX >= 0 && mouseX <= 198){
      if (mouseY >= 0 && mouseY <= 198){
        System.out.println("7");
        graphicPanel.clicked7();
        graphicPanel.gameStatus();
      }
      if (mouseY >= 202 && mouseY <= 398){
        System.out.println("4");
        graphicPanel.clicked4();
        graphicPanel.gameStatus();
      }
      if (mouseY >= 402 && mouseY <= 600){
        System.out.println("1");
        graphicPanel.clicked1();
        graphicPanel.gameStatus();
      }
    }

    //  second column
    if (mouseX >= 202 && mouseX <= 398){
      if (mouseY >= 0 && mouseY <= 198){
        System.out.println("8");
        graphicPanel.clicked8();
        graphicPanel.gameStatus();
      }
      if (mouseY >= 202 && mouseY <= 398){
        System.out.println("5");
        graphicPanel.clicked5();
        graphicPanel.gameStatus();
      }
      if (mouseY >= 402 && mouseY <= 600){
        System.out.println("2");
        graphicPanel.clicked2();
        graphicPanel.gameStatus();
      }
    }

    //  third column
    if (mouseX >= 402 && mouseX <= 600){
      if (mouseY >= 0 && mouseY <= 198){
        System.out.println("9");
        graphicPanel.clicked9();
        graphicPanel.gameStatus();
      }
      if (mouseY >= 202 && mouseY <= 398){
        System.out.println("6");
        graphicPanel.clicked6();
        graphicPanel.gameStatus();
      }
      if (mouseY >= 402 && mouseY <= 600){
        System.out.println("3");
        graphicPanel.clicked3();
        graphicPanel.gameStatus();
      }
    }

    repaint();
    infoLabel.setText(graphicPanel.getText());
  }  //  end of mouse pressed


  //  override existing functions
  public void mouseClicked(MouseEvent e){ }
  public void mouseReleased(MouseEvent e){ }
  public void mouseEntered(MouseEvent e){ }
  public void mouseExited(MouseEvent e){ }
}  //  end of mouse listener


}  // end of tictacUI
