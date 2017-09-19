//Ruler:=1=========2=========3=========4=========5=========6=========7=========8=========9=========0=========1=========2=========3
//Created by:  Brian Bui
//            iambrianbui@csu.fullerton.edu
//Created on:  14 September 2017
//Last edited:  19 September 2017
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

import java.awt.Graphics;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Point;

//  declarations
public class tictacUI extends JFrame{

//  900 width definitely, for the 300x300 squares, 900 minimum height
//  900 + 40 + 200
//  define dimensions
private final int frameWidth = 900;
private final int frameHeight = 1040;

private JPanel titlePanel;
private JLabel frameLabel;

private JPanel buttonPanel;
private JButton newGameButton;
private JButton exitButton;

private Graphicpanelclass graphicPanel;

private FlowLayout simpleFlow;
private GridLayout rowLayout;

private MouseListener minnieMouse = new mousehandler();

public tictacUI(){

  //  frame properties
  super("Tic Tac Toe");
  simpleFlow = new FlowLayout();
  rowLayout = new GridLayout(3,3);
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
  Dimension graphicPanelSize = new Dimension(frameWidth, 900);
  graphicPanel = new Graphicpanelclass();
  graphicPanel.setPreferredSize(graphicPanelSize);
  graphicPanel.setMinimumSize(graphicPanel.getPreferredSize());
  Color graphicalBG = new Color(0x8A,0x2B,0xE2);  //  find nicer color maybe
  graphicPanel.setBackground(graphicalBG);

  add(titlePanel);
  add(graphicPanel);



}  //  end of constructor

private class mousehandler implements MouseListener{
  public void mousePressed(MouseEvent ev){

  }

  public void mouseClicked(MouseEvent e){ }

  //  override existing functions
  public void mouseReleased(MouseEvent e){ }
  public void mouseEntered(MouseEvent e){ }
  public void mouseExited(MouseEvent e){ }
}


}  // end of tictacUI
