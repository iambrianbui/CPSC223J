#!/bin/bash

#Created by:  Brian Bui
#            iambrianbui@csu.fullerton.edu
#Created on:  3 October 2017
#Last edited:  3 October 2017
#Course:         Cpsc 223J
#Semester:       2017 Fall
#Assignment:     #3
#Due date:


#File name:  run.sh
#Preconditions:
#   1.  All source files are in one directory
#   2.  This file, run.sh, is in that same directory
#   3.  The shell is currently active in that same directory
#How to execute: Enter "sh run.sh" without the quotes.

echo Remove old byte-code files if any exist
rm *.class

echo View list of source files
ls -l *.java

echo Compile trafficLightAlg.java
javac trafficLightAlg.java

echo Compile trafficLightUI.java
javac trafficLightUI.java

echo Compile trafficLightMain.java
javac trafficLightMain.java

echo Execute the graphic display demonstration.
java trafficLightMain
s
echo End of execution.  Have a nice day.
