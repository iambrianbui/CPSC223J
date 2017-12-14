#!/bin/bash

#Created by:  Brian Bui
#            iambrianbui@csu.fullerton.edu
#Created on:  14 December 2017
#Last edited:  14 December 2017
#Course:         Cpsc 223J
#Semester:       2017 Fall
#Assignment:     Final
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

echo Compile polyDrawAlg.java
javac polyDrawAlg.java

echo Compile polyDrawUI.java
javac polyDrawUI.java

echo Compile polyDrawMain.java
javac polyDrawMain.java

echo Execute the graphic display demonstration.
java polyDrawMain
s
echo End of execution.  Have a nice day.
